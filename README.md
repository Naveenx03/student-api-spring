# Student API

## 📘 Project Overview

**Student API** is a backend-only RESTful web service built using **Spring Boot**.  
It provides APIs to manage student-related data such as creating, updating, retrieving, and deleting student records.

This project is designed to demonstrate **clean backend architecture**, **REST principles**, and **cloud deployment readiness**.  
There is **no frontend UI** — the application is meant to be consumed via API clients.

---

## 🌐 Live Deployment URL

**Base URL:**  
https://mysterious-mariam-naveen-g-07500c25.koyeb.app/students


> ⚠️ **Important:**  
> Visiting the base URL (`/`) will show a **blank page by design**.  
> This is expected behavior for a backend-only REST API.

---

## 🚀 How to Access the API (Important)

This application does **not** provide a web UI.

To explore and test the API:

1. Open your browser
2. Navigate to the **Swagger UI endpoint**:
	https://mysterious-mariam-naveen-g-07500c25.koyeb.app/swagger-ui/index.html
3. Use the interactive interface to:
- View all available endpoints
- Read request/response schemas
- Execute API calls directly from the browser

---

## 🧪 Swagger UI Usage Instructions

Swagger UI provides a complete interactive API console.

Steps:
1. Open `/swagger-ui/index.html`
2. Choose an endpoint (e.g., `GET /students`)
3. Click **Try it out**
4. Provide required inputs (if any)
5. Click **Execute**
6. View live responses from the deployed backend

This is the **recommended way** for recruiters and reviewers to test the application.

---

## 📌 Available API Endpoints (Examples)

| Method | Endpoint           | Description                |
|------|-------------------|----------------------------|
| GET  | `/students`        | Fetch all students         |
| GET  | `/students/{id}`   | Fetch student by ID        |
| POST | `/students`        | Create a new student       |
| PUT  | `/students/{id}`   | Update student details     |
| DELETE | `/students/{id}` | Delete a student           |

📄 Full request/response models are available in **Swagger UI**.

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (Aiven Cloud – managed database)
- **Swagger / OpenAPI** for API documentation
- **Koyeb** for cloud deployment

---

## 📝 Notes for Recruiters

- This is a **backend-focused project**, intentionally built without a frontend.
- Swagger UI is provided to make API testing easy and transparent.
- The project demonstrates:
- RESTful API design
- Cloud-ready configuration using environment variables
- Real database integration (not in-memory)

Thank you for reviewing this project 🙏

---

## ⚙️ How to Run Locally (Optional)

### Prerequisites
- Java 21
- Maven
- MySQL (local or cloud)

### Steps
```bash
git clone https://github.com/Naveenx03/student-api-spring.git
cd student-api-spring

Configure environment variables or application.properties, then run:

mvn spring-boot:run

Swagger UI (local):

http://localhost:8080/swagger-ui/index.html
