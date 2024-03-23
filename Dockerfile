
# Choose the jdk to build
FROM openjdk:21-slim as builder

# Set the working directory inside the container
WORKDIR application

# Copy the Gradle executable to the container
COPY gradle gradle
COPY gradlew .

# Copy Gradle build file
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copy source code
COPY src src

# Grant permissions for the gradlew executable
RUN chmod +x ./gradlew

# Build the application
RUN ./gradlew build -x test

# Run the Spring Boot application
FROM openjdk:21-slim
EXPOSE 8080
WORKDIR application
COPY --from=builder application/build/libs/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
