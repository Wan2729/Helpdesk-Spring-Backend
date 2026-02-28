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
