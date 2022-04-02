#!/bin/bash
./gradlew -PmainClass=com.github.ked4ma.atcoder.$1.$2Kt -Pcontest=$1 run < $3
