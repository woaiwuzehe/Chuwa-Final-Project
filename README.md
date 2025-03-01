# Online Shopping Platform - Microservices Backend

## Overview

This project implements a microservices-based online shopping backend comprising the following services:

- **Item Service:** Manages product metadata (name, price, images, UPC) and inventory using MongoDB.
- **Order Service:** Handles order creation, updates, cancellation, and lookup. Order data is stored in Cassandra. The service supports synchronous REST APIs and asynchronous messaging via Kafka.
- **Payment Service:** Processes payments, updates payment statuses, handles refunds, and allows payment lookup. Payment records are stored in MySQL, and messages are published via Kafka. Idempotency is ensured to prevent double charging/refunding.
- **Account Service:** Manages user accounts (email, username, password, shipping & billing addresses, payment methods) using MySQL/PostgreSQL.
- **Auth Server:** Provides authentication and authorization via Spring Security and JWT. Upon successful login, it issues a token that other services (e.g., Order Service) use for secured communication.

## Technology Stack

- **Spring Boot:** For rapid microservices development.
- **Spring Cloud:** For service discovery (Eureka), inter-service communication (OpenFeign/RestTemplate), and circuit breaking (Hystrix/Resilience4j).
- **Databases:**  
  - MongoDB for Item Service  
  - Cassandra for Order Service  
  - MySQL/PostgreSQL for Payment and Account Services
- **Apache Kafka:** For asynchronous, event-driven messaging.
- **Spring Security & JWT:** For authentication and token generation.
- **Docker & Docker Compose:** For containerization and one-click deployment.
- **Maven:** For dependency management and build automation.

## Architecture

Each microservice is organized into the following layers:

- **Controller:** Exposes REST APIs.
- **Service:** Contains business logic.
- **DAO/Repository:** Provides data access (using Spring Data for MongoDB, Cassandra, or JPA for relational databases).
- **Entities/DTO/Payload:** Models data for persistence and transfer between layers.
- **Util:** Contains utility classes for tasks such as converting between entities and DTOs.
- **Kafka:** Contains configuration and components for producing/consuming Kafka messages.

Services register with a Eureka server, and inter-service communication is handled both synchronously (via REST) and asynchronously (via Kafka).

## Deployment

- **Containerization:** Each microservice is built as a Docker image.
- **Docker Compose:** A unified `docker-compose.yml` file is provided to start all services and dependencies (e.g., databases, Kafka, Eureka).

## How to Run

1. **Ensure Docker is running.**
2. **Build Docker images** for each microservice using Maven and their respective Dockerfiles.
3. **Run all services** by executing:
   ```bash
   docker-compose up -d