# Fitness App Microservices

A modern, scalable fitness tracking application built using Java Spring Boot and microservices architecture. This project is part of an advanced roadmap, designed to help developers master Java, Spring Boot, microservices, and system design.


## Architecture Overview

This system is designed using a microservices-based architecture to ensure modularity, scalability, and maintainability.

### Core Services

*   **activityservice** – Manages workouts, exercises, and user activity tracking.
    
*    **aiservice** – Integrates features for personalized recommendations and analytics.
     
*    **userservice** – Handles user authentication, profile management, and user-related data.
     
*    **configserver** – Centralized configuration management for all services.
     
*    **eureka** – Service discovery with Netflix Eureka.
     
*    **gateway** – API Gateway for routing requests and handling cross-cutting concerns.
     
*    **frontend** – Frontend interface for users to interact with the application   


## Technologies Used

*    Java 17
     
*    Spring Boot
     
*    Spring Cloud (Eureka, Config Server, Gateway)
     
*    Maven
     
*    Docker (optional for containerization)
     
*    React.js(Frontend)
     
*    PostgreSQL (Database)
    

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/EmbarkXOfficial/fitness-app-microservices.git
cd fitness-app-microservices
```

### Start Services in Order

1. Start Config Server:    

```bash
cd configserver ./mvnw spring-boot:run
```

2. Start Eureka Discovery Server:

```bash
cd ../eureka ./mvnw spring-boot:run
```

3.  Start Other Microservices:     


```bash
cd ../activityservice ./mvnw spring-boot:run
cd ../userservice ./mvnw spring-boot:run
cd ../aiservice ./mvnw spring-boot:run
cd ../gateway ./mvnw spring-boot:run
```

4.  Run the Frontend:   

```bash
cd ../fitness-app-frontend # Follow frontend-specific setup instructions (e.g., npm install && npm run dev)
```

## Features

*    Microservice communication via REST APIs
     
*    Centralized configuration using Spring Cloud Config
     
*    Service discovery with Eureka
     
*    API Gateway routing and rate limiting
     
*    Modular service structure
     
*    Fitness tracking features
     
*    Frontend UI for users
     
## Testing

Each microservice is built with testable architecture. Unit and integration tests can be added using:

*    JUnit 5
     
*    Mockito
     
*    Spring Test
    
## Contributing

Contributions are welcome! Please open an issue first to discuss what you'd like to change. Make sure to follow clean code practices and add relevant documentation/comments.

## License

This project is licensed under the MIT License.
