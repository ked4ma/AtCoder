#!/bin/bash
# check xsel for alias pbcopy for linux
which xsel > /dev/null
if [ $? -eq 0 ]; then
  shopt -s expand_aliases
  alias pbcopy='xsel --clipboard --input'
fi

awk 1 src/main/java/com/github/khronos227/atcoder/$1/$2.kt src/main/java/com/github/khronos227/atcoder/utils/Functions.kt | grep -v com.github.khronos227.atcoder | grep -v -e "^\s*\/\/.*" | pbcopy
