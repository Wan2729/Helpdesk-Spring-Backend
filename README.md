# University Helpdesk System (Spring Boot Backend)

A high-performance, enterprise-grade Helpdesk REST API built with Spring Boot. This system manages ticket routing, technician assignments, departmental transfers, and workload analytics for a university campus environment.

## 🚀 Key Features

* **Automated Ticket Routing:** Analyzes ticket descriptions using keyword-matching algorithms to automatically route issues to the correct department (IT, Facilities, Finance, etc.).
* **Smart Auto-Assignment:** Automatically assigns routed tickets to the least busy technician within a specific department to ensure balanced workloads.
* **High-Performance Data Fetching:** Implements Spring Data JPA **Pagination** to prevent memory overload when fetching massive ticket datasets.
* **Optimized Caching:** Utilizes Spring `@Cacheable` to store static data (like Department directories) in memory, drastically reducing unnecessary database queries.
* **Asynchronous Processing:** Implements `@Async` background threads to handle non-blocking event notifications without slowing down the main API response times.
* **Ticket Lifecycle Management:** Full support for ticket creation, technician claiming, internal re-assignment, and inter-departmental transfers.

## 🛠️ Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 3.5.x (Spring Web, Spring Data JPA, Spring Cache)
* **Database:** PostgreSQL (Hosted on Supabase via HikariCP Connection Pool)
* **Architecture:** 3-Tier Layered Architecture (Controller / Service / Repository)
* **Tools:** Maven, Lombok, Postman (Testing)

## 📋 Database Schema
The application uses Hibernate's `ddl-auto=update` to automatically generate the relational schema, which includes:
* `User` (Inheritance strategy for Administrators, Students, Staff, and Technicians)
* `Ticket` (Tracks status, priority, submitter, assignee, and assignment history)
* `Department` (Managed via in-memory caching)
* `Notification` (Event-driven alerts)

## ⚙️ Local Setup & Installation

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/Helpdesk-Spring-Backend.git](https://github.com/YOUR_USERNAME/Helpdesk-Spring-Backend.git)
   cd Helpdesk-Spring-Backend

2. **Configure the Database:**
This project requires a PostgreSQL database.

Open src/main/resources/application.properties.

Replace the spring.datasource.url and password with your own PostgreSQL or Supabase connection string.

3. **Run the Application:**

Bash
./mvnw spring-boot:run
Note: The system includes a DataInitializer that will automatically populate the database with dummy departments, users, and historical tickets upon the first startup.

4. **Test the API:**
The server runs on http://localhost:8080. You can test the endpoints using Postman or the provided lightweight index.html frontend dashboard.

## 🔮 Future Improvements / Roadmap
While the core routing and assignment engine is complete, the following enterprise features are planned for future iterations:

1. Security: Implement Spring Security with JWT (JSON Web Tokens) for robust authentication and role-based access control (RBAC).

2. Data Transfer Objects (DTOs): Abstract database entities from the presentation layer to prevent sensitive data leakage.

3. Input Validation: Integrate spring-boot-starter-validation to sanitize and verify incoming payload requests.

4. File Attachments: Add MultipartFile support via AWS S3 or Supabase Storage for users to upload error screenshots.

5. SMTP Integration: Replace console-based notifications with real automated email alerts using spring-boot-starter-mail.
