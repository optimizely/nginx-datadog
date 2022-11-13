#!/usr/bin/env python3

import argparse
from clang import cindex
from pathlib import Path
import re

def spelling(cursor):
    if cursor.kind.name == 'INTEGER_LITERAL':
        tokens = list(cursor.get_tokens())
        if len(tokens) == 0:
            return ''
        elif len(tokens) == 1:
            return tokens[0].spelling
        else:
            return '...'
    else:
        return cursor.spelling

member_ref_exprs = []

def dump(cursor, tabstop=2, print=print):
    def recur(cursor, tabs):
        kind = cursor.kind.name
        # AST nodes unexposed to libclang are transparent.
        if kind.startswith('UNEXPOSED_'):
            for child in cursor.get_children():
                yield from recur(child, tabs)
            return
        
        if kind == 'MEMBER_REF_EXPR':
            member_ref_exprs.append(cursor)

        name = spelling(cursor)
        yield tabs, kind, name, cursor.location.file
        for child in cursor.get_children():
            yield from recur(child, tabs + 1)

    prev_tabs = 0
    for tabs, kind, name, file in recur(cursor, prev_tabs):
        if tabs:
            parens = ')' * (prev_tabs - tabs + 1)
            print(parens)
        indent = tabs * tabstop * ' '
        if kind == 'NAMESPACE' and file is not None:
            print(f'{indent}; {file}')
        maybe_name = f' {name}' if  name else ''
        print(f'{indent}({kind.lower()}{maybe_name}', end='')
        prev_tabs = tabs
    parens = ')' * (prev_tabs + 1)
    print(parens)
        
def get_cursor(cmd):
    args = list(cmd.arguments)
    flags = args[1:-1]
    tu = index.parse(cmd.filename, flags)
    return tu.cursor, tu

def dump_like(pattern, tabstop=2, print=print):
    units = list()
    for cmd in cmds:
        if not re.search(pattern, cmd.filename):
            continue
        c, tu = get_cursor(cmd)
        dump(c, tabstop, print)
        print()
        units.append(tu)
    return units 

def record_decl(expr):
    type = expr.type.get_canonical()
    if type.kind == cindex.TypeKind.POINTER:
        return type.get_pointee().get_declaration()
    elif type.kind == cindex.TypeKind.RECORD:
        return type.get_declaration()

default_dir = Path(__file__).parent/'.build'

parser = argparse.ArgumentParser(description='Print AST of matching files.')
parser.add_argument('pattern', nargs='?', help='regex pattern for filenames')
parser.add_argument('--directory', type=Path, default=default_dir)
parser.add_argument('--client', nargs='?', default='.*',
    help='regex pattern for files containing member references')
parser.add_argument('--definition', nargs='?', default='.*',
    help='regex pattern for files containing referred-to records')
parser.add_argument('--no-print', action='store_true',
    help="don't print the ASTs")
options = parser.parse_args()

index = cindex.Index.create()

db = cindex.CompilationDatabase.fromDirectory(options.directory)
cmds = list(db.getAllCompileCommands())

def no_op(*args, **kwargs):
    pass

if options.pattern is not None:
    printer = no_op if options.no_print else print
    units = dump_like(options.pattern, print=printer)

refs = []
for expr in member_ref_exprs:
    if expr.location.file is None:
        continue
    if not re.search(options.client, expr.location.file.name):
        continue
    chillins = list(expr.get_children())
    if len(chillins) != 1:
        continue
    record, = chillins
    decl = record_decl(record)
    if decl is None:
        continue
    if decl.location.file is None:
        continue
    if not re.search(options.definition, decl.location.file.name):
        continue
    refs.append((expr, decl)) 

def show(ref):
    field, decl = ref
    return f'{decl.type.spelling}.{field.spelling}'

fields = set(show(ref) for ref in refs)

def print_fields():
    for s in sorted(fields):
        print(s)


"""How do I deal with UNEXPOSED_* cursor kinds?

(a foo
  (unexposed_x bar
    (b baz))
  (unexposed_y wakka))

should become

(a foo
  (b baz))

The children of an "unexposed" end up as their grandparent's children.
"""

"""Member ref thingy

(member_ref_expr x
  (paren_expr
    (call_expr operator*
      (decl_ref_expr p)
      (decl_ref_expr operator*))))

The pattern is

(member_ref_expr <member_name>
  <node_having_record_type>)

"""
