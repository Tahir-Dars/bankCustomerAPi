# Banking Customer API
A straightforward RESTful API built with Spring Boot to manage bank customer records. This project focuses on the fundamentals of the Spring ecosystem, specifically handling object-to-database persistence and clean REST architecture.

# 🛠️ The Tech Stack
- Java (The core)

- Spring Boot (Annotations, Dependency Injection)

- Spring Data JPA (Persistence layer)

- H2  (Database)

- Maven (Build & Dependency management)

# 🚀 Features
- The API performs standard CRUD operations on Customer POJOs:

- Create: Add new customers to the system.

- Read: Retrieve all customers or a specific customer by their unique ID.

- - Update: Modify existing customer details.

Delete: Remove customer records from the database.

# 📁 Project Structure
###  Model: Contains the POJO (Plain Old Java Object) representing the Customer entity.

### Repository: Extends JpaRepository to handle data access without writing boilerplate SQL.

###  Service: Business logic layer (where the actual work happens).

###  Controller: Defines the REST endpoints and handles incoming HTTP requests.
