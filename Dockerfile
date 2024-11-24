FROM eclipse-temurin:17

WORKDIR /app

# Copy the pre-built JAR file
COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
