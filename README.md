# 📝 Journal-Application

## 📌 Overview

The Journal Application is a backend system built using Spring Boot that allows users to create, manage, and organize personal journal entries securely.

This project demonstrates core backend development concepts such as REST API design, authentication, database integration, and layered architecture.

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Database:** MySQL / MongoDB (based on configuration)
* **ORM:** Spring Data JPA / MongoRepository
* **Security:** Spring Security (Authentication & Authorization)
* **API Testing:** Postman / Swagger (if integrated)
* **Build Tool:** Maven

---

## 🧠 Architecture

The application follows a layered architecture:

Client (Postman / Frontend)
↓
Controller Layer (REST APIs)
↓
Service Layer (Business Logic)
↓
Repository Layer (Data Access)
↓
Database

---

## ✨ Features

* User Registration & Login
* Create, Read, Update, Delete Journal Entries
* Secure user-specific data handling
* RESTful API design
* Database integration
* Scalable backend structure

---

## 📂 Project Structure

src/main/java/
├── controller/     # API endpoints
├── service/        # Business logic
├── repository/     # Database operations
├── model/          # Entity/Document classes
├── config/         # Security & configurations

src/main/resources/
├── application.properties

---

## ⚙️ Installation & Setup

### ✅ Prerequisites

* Java 17+
* Maven
* MySQL or MongoDB
* IDE (IntelliJ / Eclipse)

---

### 🔽 1. Clone Repository

git clone https://github.com/Kamalsharma209/Journal-Application.git
cd Journal-Application

---

### 🗄️ 2. Setup Database

#### For MySQL:

CREATE DATABASE journal_db;

#### For MongoDB:

Ensure MongoDB is running locally.

---

### ⚙️ 3. Configure application.properties

#### 👉 MySQL Configuration

spring.datasource.url=jdbc:mysql://localhost:3306/journal_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update

#### 👉 MongoDB Configuration (if used)

spring.data.mongodb.uri=mongodb://localhost:27017/journal_db

---

### ▶️ 4. Run the Application

Using Maven:
mvn spring-boot:run

OR run the main class in your IDE.

---

### 🌐 5. Access Application

http://localhost:8080

---

## 📡 API Endpoints

### 🔐 Authentication APIs

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| POST   | /api/auth/register | Register new user |
| POST   | /api/auth/login    | User login        |

### 📝 Journal APIs

| Method | Endpoint           | Description             |
| ------ | ------------------ | ----------------------- |
| GET    | /api/journals      | Get all journal entries |
| POST   | /api/journals      | Create new entry        |
| PUT    | /api/journals/{id} | Update entry            |
| DELETE | /api/journals/{id} | Delete entry            |

---

## 🔐 Security

* Spring Security is used for authentication
* User-specific data access (each user manages their own journals)
* Can be extended with JWT authentication

---

## 🧪 Testing

You can test APIs using:

* Postman
* Swagger UI (if integrated)

---

## 🚀 Future Improvements

* JWT-based authentication
* Role-based access control
* Frontend integration (React / Angular)
* Rich text editor for journal entries
* Cloud deployment (AWS / Render)

---

## ⚠️ Known Limitations

* No frontend UI
* Basic security implementation
* Limited validation and error handling

---

## 👨‍💻 Author

Kamal Sharma
GitHub: https://github.com/Kamalsharma209

---

## ⭐ Contributing

Contributions are welcome! Feel free to fork and submit pull requests.

---

## 📜 License

This project is open-source and available under the MIT License.
