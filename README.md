This is a RESTful API built with Spring Boot, Spring Data JPA, and an H2 In-Memory Database. It allows for full CRUD (Create, Read, Update, Delete) operations on a Product entity.

🛠 Tech Stack
Java 25 (OpenJDK)

Spring Boot 3.3.4

Spring Data JPA (Hibernate)

H2 Database (In-Memory)

Swagger/OpenAPI 2.6.0 (API Documentation)

Maven (Dependency Management)

🚀 How to Run
Clone the repository to your local machine.

Ensure you have Maven installed or use the provided wrapper.

Run the application from your IDE (Run RestApiappApplication.java) or use the terminal:
The server will start on http://localhost:8080.
API Documentation (Swagger)
Once the application is running, you can test all API endpoints (GET, POST, PUT, DELETE) using the Swagger UI:

URL: http://localhost:8080/swagger-ui/index.html
Database Access (H2 Console)
The application uses an in-memory H2 database. To view the PRODUCTS table and run SQL queries:

Go to: http://localhost:8080/console

Use the following settings:

Saved Settings: Generic H2 (Embedded)

Driver Class: org.h2.Driver

JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password: (leave blank)
