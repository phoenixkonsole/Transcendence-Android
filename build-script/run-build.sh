#!/bin/bash
cp -r ./build-script/licenses /opt/android-sdk

rm ./local.properties
./gradlew init
./gradlew assembleRelease
