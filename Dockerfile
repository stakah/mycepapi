FROM adoptopenjdk/openjdk11:jre-11.0.25_9-ubuntu
COPY ./target/mycepapi-1.0-SNAPSHOT.jar .
COPY .env .
WORKDIR .


CMD ["java", "-Dspring.profiles.active=docker", "-jar", "mycepapi-1.0-SNAPSHOT.jar" ]
