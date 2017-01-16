# My Circle
A simple, secure and personal social network. No ads. No bloat.

## Stack
- Java 8
- Gradle 3 (optional)
- SpringBoot
- Docker

### Building without Docker
The below will create a JAR into `./build/libs`
```
./gradlew clean build
```

Which can be run by issuing
```
java -jar ./build/libs/mycircle-0.0.1-SNAPSHOT.jar
```

Or you can just run the application by running
```
./gradlew bootRun
```

### Building with Docker
The below will create a docker image
```
docker build -t mycirclebuild .
```

Then you can run the image by issuing
```
docker run -P --name mycircle -d mycirclebuild
```

