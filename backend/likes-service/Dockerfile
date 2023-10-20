FROM openjdk:17-alpine

WORKDIR /app

COPY target/likes-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8092

CMD ["java","-jar","app.jar"]
