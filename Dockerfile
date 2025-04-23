# ---- Build Stage ----
FROM gradle:8.4-jdk17 AS build
COPY . /home/gradle/project
WORKDIR /home/gradle/project

# Make sure gradlew is executable
RUN chmod +x ./gradlew

# Run build using gradle wrapper
RUN ./gradlew build -x test

# ---- Run Stage ----
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy built jar
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# Copy truststore if you use one
# COPY src/main/resources/ssl/truststore.jks /app/truststore.jks

# ENV TRUSTSTORE_PATH=/app/truststore.jks

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
