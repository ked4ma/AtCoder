#!/bin/bash
CSPLIT='csplit'
READLINK='readlink'
if [ "$(uname)" == 'Darwin' ]; then
  CSPLIT='gcsplit'
  READLINK='greadlink'
fi
INPUT_FILE_PATH=$($READLINK -f $3)
ANS_FILE_PATH=$($READLINK -f $4 2> /dev/null)
cd $(dirname $0)/..

mkdir -p .input
cd .input
rm ans_* 2> /dev/null

# Prepare Input Data
echo "inputs: $INPUT_FILE_PATH"
RES=$($CSPLIT -z -f input -n 1 --suppress-matched $INPUT_FILE_PATH /^---/ {*})
RES=(${RES// /})

# Prepare Ans Data
if [ -f "${ANS_FILE_PATH}" ]; then
  echo "ans   : $ANS_FILE_PATH"
  $CSPLIT -z -f ans_ -n 1 --suppress-matched $ANS_FILE_PATH /^---/ {*} > /dev/null
fi

cd ..

# Build Executable Jar
#./gradlew -PmainClass=com.github.khronos227.atcoder.$1.$2Kt -Pcontest=$1 jar
echo "[INFO] Build Executable Jar"
./gradlew -Pcontest=$1 jar

TIMEFORMAT='
time: %Rs'
for ((i = 0; i < ${#RES[@]}; i++))
do
  echo "[INFO][$((i+1))/${#RES[@]}] === Executing Sample Test ==="
  time $JAVA_HOME/bin/java -cp build/libs/AtCoder-1.0-SNAPSHOT.jar com.github.khronos227.atcoder.$1.$2Kt < .input/input$i
  if [ -e .input/ans_$i ]; then
    echo "--[ans]--"
    cat .input/ans_$i
  fi
  echo "=========="
done
