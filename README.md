# Task Management API

[![Java CI with Gradle](https://github.com/EmptinessShine/api/actions/workflows/ci.yml/badge.svg)](https://github.com/EmptinessShine/api/actions/workflows/ci.yml)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4-green)
![Security](https://img.shields.io/badge/Security-Enabled-red)

A robust RESTful API for managing tasks and categories.
Designed with a focus on **engineering best practices**: automation, security, observability, and clean architecture.

## 🛠 Tech Stack

*   **Java 21** / **Spring Boot 3.4**
*   **Spring Security** (Basic Auth protection)
*   **PostgreSQL** + **Spring Data JPA**
*   **Liquibase** (Database migrations)
*   **GitHub Actions** (CI/CD Pipeline)
*   **Mockito & JUnit 5** (Unit Testing)
*   **SLF4J** (Logging)
*   **Docker Compose** (Infrastructure)

## 💡 Key Highlights

Unlike a typical "Hello World" app, this project demonstrates skills required for **Production Support** and **Enterprise Development**:

*   **CI/CD Automation:** Configured GitHub Actions workflow to automatically build and test every commit.
*   **Observability:** Implemented detailed logging (**SLF4J**) to trace request flows and diagnose issues effectively.
*   **Reliability:** Strict database schema management via **Liquibase** (idempotent scripts) and input validation.
*   **Security:** API is protected using **Spring Security** (Basic Authentication).
*   **Quality Assurance:** Business logic is covered by Unit Tests using **Mockito**.
*   **Clean Architecture:** Usage of DTOs and Mappers (manual mapping) to decouple DB entities from the API.

## 🚀 How to Run

### 1. Infrastructure (Database)
Start PostgreSQL using Docker:
```bash
docker-compose up -d
```

### 2. Application
Run the Spring Boot application:
```bash
# Windows
gradlew bootRun

# Mac/Linux
./gradlew bootRun
```

### 3. Access
The app starts at `http://localhost:8080`.

## 🔐 Credentials (Required)
Since Security is enabled, use these credentials for Postman or Browser:
*   **Username:** `admin`
*   **Password:** `admin`

## 📚 Documentation

Interactive Swagger UI is available at:
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## ✅ Roadmap
- [x] Basic CRUD & Architecture
- [x] Database Migrations (Liquibase)
- [x] Unit Testing & Logging
- [x] CI/CD (GitHub Actions)
- [x] Security (Basic Auth)
- [ ] Add Pagination & Filtering
- [x] Dockerize the Application layer

---
**Author:** [EmptinessShine](https://github.com/EmptinessShine)