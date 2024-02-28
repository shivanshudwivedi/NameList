# NameList Spring Boot Application

## Overview
This project is a Spring Boot application that provides a simple RESTful service to manage a list of names. It supports CRUD operations (Create, Read, Update, Delete) for names stored in memory. The application also integrates Swagger for API documentation and is containerized using Docker for easy deployment and scaling.

## Story of Development
I started to code by watching tutorials on Spring Boot from Spring's website. It was really helpful to me. After that, I tried to watch YouTube that taught to build Java Based REST application. Finally, after implementing all the classes, I created the Dockerfile. I already knew to use version control, so that was the easiest part for me. Although, some of the code for NameDaoService.java had to be created from ChatGPT because it was difficult to write but later on, I understood it really well. Learning Springboot was a great exiciting journey!

## Features
- CRUD operations for name management.
- In-memory database for storing names.
- Swagger integration for API documentation.
- Docker support for containerization.

## How to Run

### http://localhost:8080/swagger-ui/index.html

### Prerequisites
- JDK 21
- Gradle
- Docker

### Running with Docker

1. **Build the Docker Image**
   Navigate to the root directory of the project and run the following command to build a Docker image.

' 
docker build -t namelist-app . 
'

2. **Run the Container**
   After the image has been successfully built, run your container using:

### docker run -p 8080:8080 namelist-app


This command runs the application on port 8080.

### Accessing the Application

## http://localhost:8080/swagger-ui/index.html

- **API Endpoints**: The application supports the following endpoints:
- `GET /names`: Retrieve all names.
- `GET /names/{id}`: Retrieve a name by its ID.
- `POST /names`: Create a new name.
- `PUT /names/{id}`: Update an existing name.
- `DELETE /names/{id}`: Delete a name.

## Development

### Build and Run Locally

1. **Build the Application**
   If you prefer to build and run the application without Docker, use the following Maven command:

### ./gradlew build


2. **Run the Application**
   After building, you can run the application using:

### java -jar target/namelist-0.0.1-SNAPSHOT.jar

## License

This project is open-source.


