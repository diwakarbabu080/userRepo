# 1️⃣ Use Maven to build the JAR
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2️⃣ Use a lightweight JDK to run the app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port (Render uses PORT env variable)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
