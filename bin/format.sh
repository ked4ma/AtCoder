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
## 1 is operated as {print}
FILES=$(grep "import com.github.ked4ma.atcoder.utils" src/main/java/com/github/ked4ma/atcoder/abc322/E_x.kt | \
        grep -v debug | \
        awk -F' ' '{print "src/main/java/"$2}' | \
        sed 's|\.|/|g' | \
        sed 's/\*/Code.kt/')
awk 1 src/main/java/com/github/ked4ma/atcoder/$1/$2.kt $(echo $FILES) | \
  grep -v com.github.ked4ma.atcoder | \
  grep -v _debug_ | \
  grep -v -e "^\s*\/\/.*" | \
  pbcopy
