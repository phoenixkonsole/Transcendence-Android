# Building

The project can be built using Android Studio. But, for the convenience, we also provide a script to build the project using a docker container.

To build the project, run ``` build-project.sh```

The script will use [mingc/android-build-box](https://hub.docker.com/r/mingc/android-build-box/) docker image to assemble the application.

<aside class="warning">
Please note that the docker image is large and requires more than 12 Gb of free storage space.
</aside>

To create a signed ***.apk***, place the ```keystore.jks``` file in the root directory of the repository. This keystore file will be used for signing the application.
Then, set the appropriate passphrases to the keystore in ```gradle.properties```. You need to set the values:
```
RELEASE_STORE_PASSWORD=<password to the keystore>
RELEASE_KEY_ALIAS=<key alias>
RELEASE_KEY_PASSWORD=<password to the specified key>
```

Do not change the ```RELEASE_STORE_FILE``` value. This value specifies the path within the docker container which always points to the root folder of the repository.

The assembled files can be found in the ```app\build\outputs\apk``` directory.
