# 🎓 Learning Management System (LMS)

A backend Learning Management System built using **Java**, **Spring Boot**, and **SQL Server**, following **Clean Architecture** principles. The system manages courses, users, roles, enrollments, and notifications, with features like pagination, sorting, filtering, and role-based access control.

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **MapStruct** (for DTO mapping)
- **SQL Server** (Database)
- **Maven** (Dependency management)
- **SLF4J + Log4j2**

## 📦 Features

- ✅ User authentication using JWT (login, token generation, token validation)
- ✅ Assign roles to users and secure endpoints based on roles
- ✅ Create and retrieve courses with pagination, sorting, and filtering
- ✅ Enroll users in courses and track their progress
- ✅ Submit assessments and view progress
- ✅ Send user notifications
- ✅ Global exception handling with structured error responses
- ✅ Logging using Log4j2
- ✅ Automatic mapping between entities and DTOs using MapStruct

## 📁 Project Structure
```plaintext
📁 src/
└── 📁 main/
    └──📁 java/
        └──📁 com/
            └──📁 learningmanagementsystem/
                ├──📁 application/
                │   ├──📁 dto/ # Request and response DTOs
                │   │   └──📁 RequestFeatures/
                │   ├──📁 mappers/ # MapStruct mappers
                │   ├──📁 service/ # Application services
                │   └──📁 usecases/ # Business logic (use cases)
                ├──📁 domain/
                │   ├──📁 entity/ # Core domain models
                │   ├──📁 exception/ # Domain-specific exceptions
                │   └──📁 repository/ # Repository interfaces
                ├──📁 infrastructure/
                │   ├──📁 config/ # Configurations (e.g., Spring secuirty)
                │   │   └──📁 security/ # Security config (JWT, filters)
                │   ├──📁 exception/ # Global exception handlers
                │   └──📁 repo/ # JPA repositories implementing domain interfaces
                ├──📁 presentation/
                │   └──📁 controllers/ # REST controllers (API layer)
                └── LearningManagementSystemApplication.java # Entry point
```
## 📦 Getting Started

### Prerequisites

* Java 21  
* Maven
* MS SQL Server
* Postman (for testing API)

### Installation

1. **Clone the Repository:**

   ```bash
    https://github.com/ZiadOsama12/Learning-Management-System.git
    cd library_management_system
   
2. **Configure the Database:**
   
   * Start MS SQL Server.
   * Create a new database called LMSSpring.
   * Update `application.properties` with your MS SQLServer credentials:
     
     ```properties
     
     spring.datasource.url=jdbc:sqlserver://your_server_name:port;database=LMSSpring;encrypt=true;trustServerCertificate=true
     spring.jpa.hibernate.ddl-auto=update
     spring.datasource.username=root
     spring.datasource.password=your_password

3. **Run the Application:**
    ```bash
    mvn spring-boot:run
4. **Test the API Endpoints:**
   
   Use Postman to test the API. For example, to add a new book:

####  🔐 4.1. Register a New User

   ```bash
   POST /api/v1/register
   Content-Type: application/json
   {
      "username":"username",
      "password":"password"
   }
  ```
####  🔑 4.2. Login to Get a JWT Token
  ```bash
    POST /api/auth/login
    Content-Type: application/json
    {
      "username":"username",
      "password":"password"
    }
```
  Sample Response:
  ```json
    {
      "access_token": "eyJhbGciOiJIUzI1N.....",
      "refresh_token": "eyJhbGciOiJI..............",
    }
  ```
####  🔓 4.3. Access Protected Endpoints

```bash
  POST /api/v1/courses
  Authorization: Bearer <your_token_here>
  Content-Type: application/json
  {
    "title":"coursetilte",
    "description": "description",
    "category":"category",
    "status":"draft"
  }
```

## 🤝 Contributions
Pull requests are welcome. For major changes, open an issue first to discuss what you would like to change.

## 📌 Future Improvements
* Unit and integration tests

* Email or SMS notifications

* Frontend integration (React/Angular)

* Admin dashboard

## 💬 Contact

For any questions or suggestions, feel free to reach out:

* **Email:** ziadosama9595@gmail.com
* **GitHub:** [Ziad Osama](https://github.com/ZiadOsama12)

