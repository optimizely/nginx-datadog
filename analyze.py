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

def dump(cursor, tabstop=2, print=print):
    def recur(cursor, tabs):
        kind = cursor.kind.name
        # AST nodes unexposed to libclang are transparent.
        if kind.startswith('UNEXPOSED_'):
            for child in cursor.get_children():
                yield from recur(child, tabs)
            return
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
    return tu.cursor

def dump_like(pattern):
    for cmd in cmds:
        if not re.search(pattern, cmd.filename):
            continue
        c = get_cursor(cmd)
        cc = list(c.get_children())
        dump(c)
        print()

default_dir = Path(__file__).parent/'.build'

parser = argparse.ArgumentParser(description='Print AST of matching files.')
parser.add_argument('pattern', nargs='?', help='regex pattern for filenames')
parser.add_argument('--directory', type=Path, default=default_dir)
options = parser.parse_args()

index = cindex.Index.create()

db = cindex.CompilationDatabase.fromDirectory(options.directory)
cmds = list(db.getAllCompileCommands())

if options.pattern is not None:
    dump_like(options.pattern)

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
