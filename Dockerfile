# Stage 1: Build the JAR using Maven
FROM maven:3.9.2-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the JAR (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Stage 2: Run the Spring Boot app
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Render will use
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
