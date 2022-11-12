#!/usr/bin/env python3

from clang import cindex
from pathlib import Path

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
        indent = tabs * tabstop * ' '
        name = spelling(cursor)
        separator = ' ' if name else ''
        print(f'{indent}({cursor.kind.name}{separator}{name}', end='')
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

def dump_all():
    for cmd in cmds:
        c = get_cursor(cmd)
        cc = list(c.get_children())
        dump(c)
        print()

