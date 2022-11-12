#!/usr/bin/env python3

import argparse
from clang import cindex
from pathlib import Path
import re

index = cindex.Index.create()

repo = Path(__file__).parent
db = cindex.CompilationDatabase.fromDirectory(repo/'.build')
cmds = list(db.getAllCompileCommands())

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

def dump(cursor, tabstop=2):
    def recur(cursor, tabs):
        kind = cursor.kind.name
        # AST nodes unexposed to libclang are transparent.
        if kind.startswith('UNEXPOSED_'):
            for child in cursor.get_children():
                # TODO too many newlines
                print()
                recur(child, tabs)
            return
        indent = tabs * tabstop * ' '
        name = spelling(cursor)
        separator = ' ' if name else ''
        print(f'{indent}({kind}{separator}{name}', end='')
        for child in cursor.get_children():
            print(end='\n')
            recur(child, tabs + 1)
        print(')', end='')
    recur(cursor, 0)
    print()

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

parser = argparse.ArgumentParser(description='Print AST of matching files.')
parser.add_argument('pattern', default='.*', help='regex pattern for filenames')
options = parser.parse_args()

dump_like(options.pattern)

"""How do I deal with UNEXPOSED_* cursor kinds?

(a foo
  (unexposed_x bar
    (b baz))
  (unexposed_y wakka))

should become

(a foo
  (b baz))

The children of an "unexposed" end up in their parent's place.
"""
