#!/bin/bash
./gradlew -PmainClass=com.github.khronos227.atcoder.$1.$2Kt -Pcontest=$1 run < $3
