🎓 University Helpdesk System (Spring Boot Backend)

A high-performance, enterprise-grade Helpdesk REST API built with Spring Boot.
This system manages ticket routing, technician assignments, departmental transfers, and workload analytics for a university campus environment.

🚀 Key Features
🔄 Automated Ticket Routing

Analyzes ticket descriptions using keyword-matching algorithms to automatically route issues to the correct department (IT, Facilities, Finance, etc.).

👨‍🔧 Smart Auto-Assignment

Automatically assigns routed tickets to the least busy technician within a specific department to ensure balanced workloads and improved efficiency.

📊 High-Performance Data Fetching

Implements Spring Data JPA Pagination to prevent memory overload when fetching large ticket datasets.

⚡ Optimized Caching

Uses Spring @Cacheable to store static data (e.g., Department directories) in memory, significantly reducing unnecessary database queries.

🔔 Asynchronous Processing

Implements @Async background threads to handle non-blocking event notifications without slowing down main API response times.

🔁 Ticket Lifecycle Management

Full support for:

Ticket creation

Technician claiming

Internal re-assignment

Inter-departmental transfers

Status and priority tracking

🛠️ Tech Stack
Layer	Technology
Language	Java 17
Framework	Spring Boot 3.5.x (Spring Web, Spring Data JPA, Spring Cache)
Database	PostgreSQL (Hosted on Supabase via HikariCP Connection Pool)
Architecture	3-Tier Layered Architecture (Controller / Service / Repository)
Build Tool	Maven
Utilities	Lombok, Postman (API Testing)
🗄️ Database Schema

The application uses Hibernate's ddl-auto=update to automatically generate the relational schema.

Core Entities:

User

Uses inheritance strategy

Roles include: Administrator, Student, Staff, Technician

Ticket

Tracks:

Status

Priority

Submitter

Assignee

Assignment history

Department

Managed via in-memory caching

Notification

Event-driven alert system

⚙️ Local Setup & Installation
1️⃣ Clone the Repository
git clone https://github.com/YOUR_USERNAME/Helpdesk-Spring-Backend.git
cd Helpdesk-Spring-Backend
2️⃣ Configure the Database

This project requires a PostgreSQL database.

Open:

src/main/resources/application.properties

Replace the following properties with your own PostgreSQL or Supabase credentials:

spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
3️⃣ Run the Application
./mvnw spring-boot:run

Or on Windows:

mvnw.cmd spring-boot:run

✅ Note:
The system includes a DataInitializer that automatically populates the database with:

Dummy departments

Sample users

Historical tickets

This runs only on first startup.

4️⃣ Test the API

The server runs on:

http://localhost:8080

You can test endpoints using:

Postman

The provided lightweight index.html frontend dashboard

🏗️ Architecture Overview

The application follows a 3-Tier Layered Architecture:

Controller → Service → Repository → Database

Controller Layer → Handles HTTP requests & responses

Service Layer → Contains business logic (routing, assignment, workload balancing)

Repository Layer → Handles database access using Spring Data JPA

🔮 Future Improvements / Roadmap

While the core routing and assignment engine is complete, the following enterprise-grade features are planned:

🔐 Security

Implement Spring Security

JWT-based authentication

Role-Based Access Control (RBAC)

📦 Data Transfer Objects (DTOs)

Separate entities from API responses

Prevent sensitive data exposure

✅ Input Validation

Integrate spring-boot-starter-validation

Enforce request payload sanitization

📎 File Attachments

Add MultipartFile support

Upload screenshots via AWS S3 or Supabase Storage

📧 SMTP Integration

Replace console-based notifications

Enable real automated email alerts via spring-boot-starter-mail
