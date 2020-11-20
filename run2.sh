#!/bin/bash
INPUT_FILE_PATH=$(readlink -f $3)
cd $(dirname $0)

# Prepare Input Data
echo $INPUT_FILE_PATH
mkdir -p .input
cd .input
RES=$(csplit -z -f input -n 1 --suppress-matched $INPUT_FILE_PATH /^---/ {*})
RES=(${RES// /})
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
  echo "=========="
done
