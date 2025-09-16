# 🛠️ Microservices Project with AWS SQS, Eureka Server, and API Gateway

This project demonstrates a microservices architecture using Spring Boot. It includes inter-service communication using **REST API Gateway** and **asynchronous messaging via AWS SQS**. Service discovery is handled by **Eureka Server**.

---

## 📦 Project Structure

### 1. `user-service`
- **Purpose**: Manages user-related operations.
- **Responsibilities**:
  - Registers users.
  - Listens to product-related events via AWS SQS queue (`product-events-queue`).
- **Endpoints**:
  - `POST /api/users` – Create new user.
- **AWS Integration**: Consumes messages from SQS queue using `@SqsListener`.

---

### 2. `product-service`
- **Purpose**: Manages product-related operations.
- **Responsibilities**:
  - Creates products.
  - Publishes events to AWS SQS when a product is created.
- **Endpoints**:
  - `POST /api/products` – Add new product.
- **AWS Integration**: Publishes events to SQS using `QueueMessagingTemplate`.

---

### 3. `api-gateway`
- **Purpose**: Entry point to all services.
- **Responsibilities**:
  - Routes requests to `user-service` and `product-service`.
  - Optionally includes **JWT authentication filter** (`JwtAuthFilter`) and **CORS configurations** (`GatewayConfig`).
- **Tech**: Spring Cloud Gateway.

---

### 4. `eureka-server`
- **Purpose**: Handles service discovery.
- **Responsibilities**:
  - Maintains a registry of all microservices.
  - Allows services to register themselves and discover others.
- **Tech**: Netflix Eureka.

---

## ☁️ AWS Integration

- **Service Used**: Amazon Simple Queue Service (SQS)
- **Queue Name**: `product-events-queue`
- **Flow**:
  - `product-service` pushes messages to SQS.
  - `user-service` listens and consumes those messages asynchronously.

---

## 🚀 Getting Started

### Prerequisites:
- Java 17+
- Docker + Docker Compose
- AWS Account (Free Tier works)
- Spring Boot
- Maven

### Run Locally:
```bash
# Start Eureka Server
cd eureka-server && mvn spring-boot:run

# Start API Gateway
cd api-gateway && mvn spring-boot:run

# Start user-service
cd user-service && mvn spring-boot:run

# Start product-service
cd product-service && mvn spring-boot:run
