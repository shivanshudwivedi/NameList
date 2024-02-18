#FROM ubuntu:latest
#LABEL authors="shivanshu"

#Base image of JDK
FROM openjdk:21-jdk-slim as build

#Add a volume pointing to /tmp
VOLUME /tmp

#Make port 8080 avaialbel to the world outside this container
EXPOSE 8080

#The application's jar file
ARG JAR_FILE=build/libs/*.jar

#Add the application's Jar to container
ADD ${JAR_FILE} app.jar

#Run the jar file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]





#ENTRYPOINT ["top", "-b"]