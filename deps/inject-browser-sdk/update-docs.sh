#!/bin/bash

set -euo pipefail


if output=$(git status --porcelain) && ! [ -z "$output" ]; then 
  echo "Aborting due to uncommitted changes:"
  echo
  git status
  exit 1
fi

(
  cd lib;
  cargo clean --doc
  cargo doc --document-private-items --no-deps
)

git checkout docs

git rm -r ':!:.gitignore' ':!:index.html' # remove all tracked files except .gitignore and index.html
cp -r lib/target/doc/* .

git add .
git commit -m "update docs"
