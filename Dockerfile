FROM openjdk:17-oracle

EXPOSE 8091

ADD target/diplomCloudStorage-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]