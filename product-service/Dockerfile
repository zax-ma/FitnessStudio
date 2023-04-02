FROM bellsoft/liberica-openjdk-alpine:latest
MAINTAINER MZ

COPY target/product-service-0.0.1-SNAPSHOT.jar product-service.jar
ENTRYPOINT ["java", "-jar", "/product-service.jar"]

EXPOSE 8080