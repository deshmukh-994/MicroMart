# Use Java 17 image
FROM openjdk:17-jdk-slim

# Add your jar file
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]
