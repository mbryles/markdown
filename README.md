# markdown

A simple command-line markdown processor for files

##Building
Use the maven wrapper to clean and install the binary:

```console
$ ./mvnw clean install
```

##Running the App

Invoke the jar like you would any other java CLI app and pass in 2 arguments: the input file and the
output file. Feel free to the use in the input file provided.

```console
$ java -jar target/markdown-1.0-SNAPSHOT.jar input.txt output.txt
```
