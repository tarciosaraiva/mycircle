FROM openjdk:8
MAINTAINER tarcio@gmail.com

ARG VERSION=0.0.1-SNAPSHOT

RUN mkdir -p /opt/mycircle/current
WORKDIR /opt/mycircle/current

# Copy needed files
COPY build/libs/mycircle-${VERSION}.jar /opt/mycircle/current/mycircle.jar

EXPOSE 3001

CMD ["java", "-jar", "/opt/mycircle/current/mycircle.jar"]
