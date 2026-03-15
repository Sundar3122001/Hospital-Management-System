# 🏥 Hospital Management System (Spring Boot + JWT + PostgreSQL)

A **secure RESTful backend application** for managing hospital operations such as **patients, doctors, appointments, billing, and services**.
The system uses **Spring Boot**, **PostgreSQL**, and **JWT-based authentication with Spring Security** to provide a scalable and secure backend.

---

# 🚀 Features

* User Registration and Login
* JWT-based Authentication and Authorization
* Secure REST APIs using Spring Security
* Stateless Session Management
* Role-based User Structure (ADMIN / DOCTOR / PATIENT)
* Patient Management
* Doctor Management
* Appointment Scheduling
* Billing and Payment Tracking
* Hospital Services Management
* PostgreSQL Database Integration
* Layered Architecture (Controller → Service → Repository)

---

# 🛠 Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Security
* JWT (io.jsonwebtoken)

## Database

* PostgreSQL
* Spring Data JPA
* Hibernate

## Tools

* Maven
* Postman
* Git
* GitHub

---

# 📁 Project Structure

src/main/java/com/example/HospitalManagementSystemApplication

config
SecurityConfig
JwtAuthenticationFilter

controllers
AuthController
PatientController
DoctorController
AppointmentController
BillController
ServiceController

service
JwtService
UsersService
CustomUserDetailsService
PatientService
DoctorService
AppointmentService
BillService
ServiceService

repository
UserRepository
PatientRepository
DoctorRepository
AppointmentRepository
BillRepository
ServiceRepository

models
Users
Role
Patient
Doctor
Appointment
Bill
Service

---

# 🔐 JWT Authentication Flow

1. User sends login request with credentials.
2. Server verifies username and password.
3. JWT token is generated upon successful authentication.
4. Client stores the token.
5. Client sends the token in the Authorization header for protected APIs.
6. JWT filter validates the token before allowing access to endpoints.

Authorization Header Format:

Authorization: Bearer <JWT_TOKEN>

---

# 📌 API Endpoints

## Authentication

Register User

POST /auth/register

Request Body

{
"username": "admin",
"password": "12345",
"email": "[admin@gmail.com](mailto:admin@gmail.com)",
"role": "ADMIN"
}

Login User

POST /auth/login

Request Body

{
"username": "admin",
"password": "12345"
}

Response

JWT_TOKEN

---

# 👤 Patient APIs

Create Patient

POST /patients

Get All Patients

GET /patients

Get Patient by ID

GET /patients/{id}

---

# 👨‍⚕️ Doctor APIs

Add Doctor

POST /doctors

Get All Doctors

GET /doctors

Get Doctor by ID

GET /doctors/{id}

---

# 📅 Appointment APIs

Create Appointment

POST /appointments

Get All Appointments

GET /appointments

Get Appointment by ID

GET /appointments/{id}

---

# 💳 Billing APIs

Create Bill

POST /bills

Get All Bills

GET /bills

Get Bill by ID

GET /bills/{id}

---

# 🛠 Service APIs

Create Service

POST /services

Get All Services

GET /services

Get Service by ID

GET /services/{id}

---

# ⚙️ Setup Instructions

## 1 Clone the Repository

git clone https://github.com/yourusername/hospital-management-system.git

---

## 2 Navigate to the Project

cd hospital-management-system

---

## 3 Configure Database

Update application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

## 4 Run the Application

mvn spring-boot:run

Application will start at:

http://localhost:8080

---

# 🧪 Testing APIs

Use **Postman** to test the APIs.

Recommended testing order:

1. Register a user
2. Login to generate JWT token
3. Add token in Authorization header
4. Access protected APIs

Example Header:

Authorization: Bearer JWT_TOKEN

---

# 📚 Key Concepts Demonstrated

* REST API Development using Spring Boot
* Secure Authentication using JWT
* Stateless Security Architecture
* Spring Security Filter Chain
* Database Integration with Spring Data JPA
* Layered Backend Architecture
* Role-based System Design

---

# 👨‍💻 Author

Shanmugasundaram M
Software Engineer | Backend Developer (Java / Spring Boot)

GitHub: https://github.com/yourusername

---

# ⭐ Support

If you found this project helpful, please give it a ⭐ on GitHub!
