# Task Management API
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)

A backend API for managing tasks and categories.  
Built to practice **Spring Boot 3**, **PostgreSQL** migrations, and **Docker** integration.


## 🛠 Tech Stack

*   **Java 17** / **Spring Boot 3.2**
*   **PostgreSQL** + **Spring Data JPA**
*   **Liquibase** (Schema management)
*   **Docker** & **Docker Compose**
*   **Swagger/OpenAPI** (Documentation)
*   **MapStruct** (DTO mapping)

## 💡 Key Highlights

Unlike a typical "Hello World" app, here I focused on production-like practices:

*   **Database Migrations:** Using Liquibase to manage schema changes instead of `ddl-auto`.
*   **Exception Handling:** Custom `GlobalExceptionHandler` returning proper JSON errors (RFC 7807 problem details or similar structure).
*   **DTOs:** Entities are completely decoupled from the API layer.
*   **Validation:** Strict input validation via Hibernate Validator.

## 🚀 How to Run

Requires **Docker** and **Docker Compose**.

1. Clone the repo:
   ```bash
   git clone https://github.com/EmptinessShine/api.git
   ```

2. Run the stack:
   ```bash
   docker-compose up -d
   ```

3. The app starts at `http://localhost:8080`.

## 📚 Documentation

Swagger UI is available at:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

You can use it to create categories and tasks directly from the browser.

## ✅ TODO / Roadmap

Plans for future updates:
- [ ] Add JWT Authentication (Spring Security)
- [ ] Integration tests with Testcontainers
- [ ] Add filtering and pagination for tasks

---

**Author:** [EmptinessShine](https://github.com/EmptinessShine)
