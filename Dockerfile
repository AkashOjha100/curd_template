# Use Java 17 (or your version)
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/*.jar app.jar

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]