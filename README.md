`getter` is a little Java program that is useful inside containers where curl is not yet installed. It downloads a tgz file and streams it to a locally installed `tar` executable to extract the contents.

## Usage

```shell
./gradlew textEncodeClasses
```

The base64 encoded version of GetTgz is located in `build/classesAsText`

You can then reconstitute the java class file on a remote system by `echo`ing the contents of the b64 file:

```shell
echo "..." | base64 -d > GetTgz.class
```