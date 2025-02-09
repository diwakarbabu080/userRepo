# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the application port (Render uses PORT env variable)
EXPOSE 10000

# Command to run the application
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]

