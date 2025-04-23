# ---- Build Stage ----
FROM gradle:8.4-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build -x test

# ---- Run Stage ----
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy built jar
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# Copy truststore from source
COPY src/main/resources/ssl/truststore.jks /app/truststore.jks

ENV TRUSTSTORE_PATH=/app/truststore.jks
ENV TRUSTSTORE_PASSWORD=${TRUSTSTORE_PASSWORD}  # Or set it via Render dashboard

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
