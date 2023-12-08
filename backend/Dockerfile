# Etapa 1: Construye la aplicación Spring Boot
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

# Etapa 2: Crea la imagen final de la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/track.jar /app/track.jar
EXPOSE 8080
CMD ["java", "-jar", "track.jar"]