# syntax = docker/dockerfile:1.2
#
# Build stage
#
FROM maven:3.8.6-openjdk-18 AS build
COPY . .
RUN mvn clean package assembly:single -DskipTests
#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/API-Calculo-Grado-Impacto-0.0.1-SNAPSHOT-jar-with-dependencies.jar servicioAPI.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-classpath","servicioAPI.jar","com.grupo15.API.Calculo.Grado.Impacto.ApiCalculoGradoImpactoApplication"]