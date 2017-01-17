FROM frekele/gradle:3-jdk8
MAINTAINER tarcio@gmail.com

ARG VERSION=0.0.1-SNAPSHOT

RUN mkdir -p /opt/mycircle/current
RUN mkdir -p /tmp/mycircle
WORKDIR /tmp/mycircle

# Copy needed files
COPY build.gradle /tmp/mycircle/build.gradle
COPY src /tmp/mycircle/src

# build
RUN gradle clean
RUN gradle testClasses
RUN gradle test
RUN gradle build -Pversion=${VERSION}

RUN mv build/libs/mycircle-${VERSION}.jar /opt/mycircle/current/mycircle.jar

RUN rm -rf /tmp/mycircle
WORKDIR /opt/mycircle/current

EXPOSE 3001

CMD ["java", "-jar", "/opt/mycircle/current/mycircle.jar"]
