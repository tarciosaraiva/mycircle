FROM openjdk:8
MAINTAINER tarcio@gmail.com

ARG VERSION=0.0.1-SNAPSHOT

ENV USERS_DBURL jdbc:mysql://127.0.0.1/mycircle
ENV USERS_DBUSR mycircle
ENV USERS_DBPWD mycircle
ENV DATA_DBURL jdbc:postgresql://127.0.0.1/mycircle
ENV DATA_DBUSR mycircle
ENV DATA_DBPWD mycircle
ENV AUTH0_CLIENT_ID fake_id
ENV AUTH0_CLIENT_SECRET fake_secret

RUN mkdir -p /opt/mycircle/current
WORKDIR /opt/mycircle/current

# Copy needed files
COPY build/libs/mycircle-${VERSION}.jar /opt/mycircle/current/mycircle.jar

EXPOSE 3001

CMD ["java", "-Dapp.datasource.data.url=${DATA_DBURL}", "-Dapp.datasource.users.url=${USERS_DBURL}", "-Dauth0.clientId=${AUTH0_CLIENT_ID}", "-Dauth0.clientSecret=${AUTH0_CLIENT_SECRET}", "-jar", "/opt/mycircle/current/mycircle.jar"]
