#!/bin/bash
# check xsel for alias pbcopy for linux
which xsel > /dev/null
if [ $? -eq 0 ]; then
  shopt -s expand_aliases
  alias pbcopy='xsel --clipboard --input'
fi

# 1. copy functions of Functions.kt to the source code
# 2. remove util imports
# 3. remove debug functions
# 4. remove comment
awk 1 src/main/java/com/github/khronos227/atcoder/$1/$2.kt src/main/java/com/github/khronos227/atcoder/utils/Functions.kt | \
  grep -v com.github.khronos227.atcoder | \
  grep -v _debug_ | \
  grep -v -e "^\s*\/\/.*" | \
  pbcopy
