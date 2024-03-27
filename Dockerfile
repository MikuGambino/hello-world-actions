FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/hello_world.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/hello_world.jar"]