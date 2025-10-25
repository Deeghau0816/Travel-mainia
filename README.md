# 🌍 TravelMania

**TravelMania** is a **Java web application** designed for managing tours, bookings, and user registrations.  
Built with **JSP**, **Servlets**, and **MySQL**, the system follows the **MVC architecture** to ensure scalability, maintainability, and separation of concerns.

🔗 **Repository:** [github.com/Deeghau0816/Travel-mainia](https://github.com/Deeghau0816/Travel-mainia)

---

## 🚀 Project Overview

TravelMania provides an online platform to manage **tour packages, bookings, and admin operations** efficiently.  
It supports full **CRUD functionality**, basic authentication, and a **role-based access control** system.

As the **Team Leader**, I led the design and development of the full stack—overseeing database integration, servlet logic, and user interface components.

---

## ✨ Key Features

- 🏖️ Manage tours, packages, and bookings  
- 👥 User registration and authentication  
- 🧩 Full CRUD (Create, Read, Update, Delete) functionality  
- 🧭 Clean MVC structure (Model–View–Controller)  
- 🗄️ Persistent storage using **MySQL**  
- 🔐 Role-based access control (Admin & User)  
- 📦 Ready-to-import SQL script (`tourguid.sql`)  

---

## 🛠️ Tech Stack

| Layer | Technologies |
|-------|---------------|
| **Frontend** | JSP, HTML, CSS, JavaScript |
| **Backend** | Java Servlets, JDBC |
| **Database** | MySQL |
| **Server** | Apache Tomcat 9+ |
| **Architecture** | MVC (Model–View–Controller) |

---

## 📁 Project Structure



## Project structure suggestion

A typical layout for this kind of project:
```
/ (project root)
├─ BookingPackage/
├─ Controller/
├─ RegisterPack/
├─ adminPackage/
├─ model/
├─ services/
├─ servlets/
├─ tourOfferPackage/
├─ JS/ WebJS/
├─ WEB-INF/
│  ├─ web.xml
│  └─ lib/
├─ tourguid.sql
└─ README.md
```

---

## Testing

- There are no automated tests included by default (inspect `tests/` or similar if you add them).
- You can add JUnit tests for service/DAO logic and integration tests for database interactions.

---

## Deployment

- Package the app as a WAR and deploy to Tomcat (or another servlet container that supports JSP/Servlet spec).
- Ensure production DB credentials and connection pool settings are configured via environment variables or secure config files.
- Consider using a connection pool (Tomcat DBCP / HikariCP) for better performance.

