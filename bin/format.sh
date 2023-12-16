#!/bin/bash
# check xsel for alias pbcopy for linux
which xsel > /dev/null
if [ $? -eq 0 ]; then
  shopt -s expand_aliases
  alias pbcopy='xsel --clipboard --input'
fi


function parsePackages() {
  local -n ARR=$1
  local -n RES=$2
  local PACKS=()
  for F in ${ARR[@]}; do
    FILES=($(grep "import com.github.ked4ma.atcoder.utils" $F | \
            grep -v debug | \
            awk -F' ' '{print "src/main/java/"$2}' | \
            sed 's|\.|/|g' | \
            sed 's/\*/Code.kt/'))
    PACKS+=("${FILES[@]}")
  done
  RES=($(printf "%s\n" "${PACKS[@]}" | sort -u))
}

# 1. copy functions of Functions.kt to the source code
# 2. remove util imports
# 3. remove debug functions
# 4. remove comment
## 1 is operated as {print}
declare -a TARGETS=(src/main/java/com/github/ked4ma/atcoder/$1/$2.kt)
declare -a PACKAGES=()
while true; do
  parsePackages TARGETS PACKAGES
  if [ ${#TARGETS[@]} -eq $((${#PACKAGES[@]}+1)) ]; then
    break
  fi
  TARGETS+=(${PACKAGES[@]})
  TARGETS=($(printf "%s\n" "${TARGETS[@]}" | sort -u))
done
for P in ${PACKAGES[@]}; do
  echo "package: $P"
done
awk 1 src/main/java/com/github/ked4ma/atcoder/$1/$2.kt ${PACKAGES[@]} | \
  grep -v com.github.ked4ma.atcoder | \
  grep -v _debug_ | \
  grep -v -e "^\s*\/\/.*" | \
  grep -v -e "^$" | \
  pbcopy
