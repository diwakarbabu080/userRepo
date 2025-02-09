# Use official Java 17 runtime image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper files and source code
COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src src

# Grant execute permissions to the Maven wrapper
RUN chmod +x ./mvnw

# Build the JAR file
RUN ./mvnw clean package -DskipTests

# Copy the generated JAR file to run
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
