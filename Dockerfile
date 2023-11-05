FROM openjdk:21-ea-32-jdk-slim
WORKDIR /app
COPY target/crezze-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","crezze-0.0.1-SNAPSHOT.jar"]