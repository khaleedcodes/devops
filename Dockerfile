# Use official Maven image to build the application
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run Maven build (creates JAR file inside /target)
RUN mvn clean package

# Use a lightweight JDK image to run the app
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (for web access)
EXPOSE 8080

# Run the Java application
CMD ["java", "-jar", "app.jar"]
