@echo off
docker pull mingc/android-build-box:1.11.0

docker run -v %~dp0:/home/build -w="/home/build" mingc/android-build-box:1.11.0 /bin/bash -c /home/build/build-script/run-build.sh 
