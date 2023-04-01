FROM bellsoft/liberica-openjdk-alpine:latest
MAINTAINER MZ

COPY target/user-service-1.jar user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]