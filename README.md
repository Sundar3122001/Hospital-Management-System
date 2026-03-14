# 🏥 Hospital Management System (Spring Boot)

A **Spring Boot REST API** project that manages core hospital operations such as **Doctors, Patients, Appointments, and Billing**.
This project demonstrates a clean backend architecture using **Spring Boot, Spring Data JPA, Lombok, and PostgreSQL**.

---

## 🚀 Features

* Doctor Management (CRUD)
* Patient Management (CRUD)
* Appointment Booking
* Bill Generation
* Pagination Support
* RESTful API Design
* JPA Entity Relationships

---

## 🧱 Project Architecture

```
Doctor
   │
   │
Appointment ─── Patient
   │
   │
   Bill
```

### Relationships

* **Appointment → Doctor** : Many-to-One
* **Appointment → Patient** : Many-to-One
* **Bill → Appointment** : One-to-One

---

## 🛠️ Tech Stack

| Technology      | Description                  |
| --------------- | ---------------------------- |
| Java 17         | Programming Language         |
| Spring Boot     | Backend Framework            |
| Spring Data JPA | ORM for database interaction |
| PostgreSQL      | Database                     |
| Lombok          | Reduces boilerplate code     |
| Maven           | Dependency Management        |
| IntelliJ IDEA   | IDE                          |

---

## 📁 Project Structure

```
HospitalManagementSystem
│
├── controllers
│   ├── DoctorController
│   ├── PatientController
│   ├── AppointmentController
│   └── BillController
│
├── service
│   ├── DoctorService
│   ├── PatientService
│   ├── AppointmentService
│   └── BillService
│
├── repository
│   ├── DoctorRepository
│   ├── PatientRepository
│   ├── AppointmentRepository
│   └── BillRepository
│
├── models
│   ├── Doctor
│   ├── Patient
│   ├── Appointment
│   └── Bill
│
└── HospitalManagementSystemApplication
```

---

## ⚙️ API Endpoints

### 👨‍⚕️ Doctor APIs

Create Doctor

```
POST /api/v1/doctors
```

Get All Doctors

```
GET /api/v1/doctors
```

Update Doctor

```
PUT /api/v1/doctors/{id}
```

Delete Doctor

```
DELETE /api/v1/doctors/{id}
```

---

### 🧑 Patient APIs

Create Patient

```
POST /api/v1/patients
```

Get All Patients

```
GET /api/v1/patients
```

Update Patient

```
PUT /api/v1/patients/{id}
```

Delete Patient

```
DELETE /api/v1/patients/{id}
```

---

### 📅 Appointment APIs

Create Appointment

```
POST /api/v1/appointments?patientId={id}&doctorId={id}
```

Example Request Body

```json
{
  "appointmentTime": "2026-03-20T10:30:00",
  "status": "Scheduled"
}
```

Get All Appointments

```
GET /api/v1/appointments
```

---

### 💳 Bill APIs

Generate Bill

```
POST /api/v1/bills?appointmentId={id}
```

Example Request Body

```json
{
  "consultationFee": 500,
  "medicineCost": 200,
  "paymentStatus": "PAID"
}
```

Get All Bills

```
GET /api/v1/bills
```

---

## 📊 Example Bill Response

```json
{
  "id": 1,
  "consultationFee": 500,
  "medicineCost": 200,
  "totalAmount": 700,
  "paymentStatus": "PAID",
  "appointment": {
    "id": 1,
    "appointmentTime": "2026-03-20T10:30:00",
    "status": "Scheduled"
  }
}
```

---

## ▶️ Running the Project

1. Clone the repository

```
git clone https://github.com/yourusername/hospital-management-system.git
```

2. Open in **IntelliJ IDEA**

3. Configure database in `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Run the application

```
HospitalManagementSystemApplication.java
```

Server starts at:

```
http://localhost:8080
```

---

## 📌 Future Improvements

* DTO Layer
* Global Exception Handling
* Validation using `@Valid`
* Swagger API Documentation
* Authentication & Authorization (Spring Security)
* Frontend Integration

---

## 👨‍💻 Shanmugasundaram

Developed as a **Spring Boot Backend Practice Project** to demonstrate REST API design and database relationships.
