FROM openjdk:17-jdk

LABEL authors="khanhtq"

WORKDIR /app

COPY target/department-service-0.0.1-SNAPSHOT.jar /app/department-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/department-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
