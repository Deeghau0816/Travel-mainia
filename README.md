```markdown
# TravelMania

TravelMania is a Java web application for property, tour and booking management built with JSP, Servlets and MySQL. The app follows the MVC pattern and provides full CRUD operations with role-based access and a responsive user interface.

Repository: https://github.com/Deeghau0816/Travel-mainia

---

## Key Features

- Manage properties, tours, and bookings
- Full CRUD (Create, Read, Update, Delete)
- JSP-based user interfaces (views)
- Java Servlets + JDBC for backend (controllers & persistence)
- MVC architecture (model, view, controller separation)
- Persistent storage in MySQL
- Basic authentication and role-based access control
- Includes SQL schema/data import script (tourguid.sql)

---

## Tech Stack

- Frontend: JSP, HTML, CSS, JavaScript
- Backend: Java Servlets, JDBC
- Database: MySQL
- Server: Apache Tomcat 9+
- Architecture: MVC

---

## Repository overview

Top-level folders and notable files in this repo:

- BookingPackage/       — Booking-related classes
- Controller/           — Controller helpers (may contain servlet helpers)
- JS/                   — JavaScript assets
- RegisterPack/         — Registration-related classes
- WebJS/                — Web JavaScript / client-side scripts
- adminPackage/         — Admin-related backend classes
- model/                — Domain model classes (POJOs)
- services/             — Service / business logic layer
- servlets/             — Servlets (controllers for HTTP endpoints)
- tourOfferPackage/     — Tour offering-related classes
- tourguid.sql          — Database schema and seed data (important)
- xml.xml               — Additional XML resource (inspect for usage)

(Adjust any folder descriptions if you know they map to different responsibilities in your code.)

---

## Quick start — Local development

Prerequisites
- Java JDK 8+ (11 recommended)
- Apache Tomcat 9+
- MySQL 5.7+ / 8.0+
- (Optional) An IDE such as Eclipse, IntelliJ IDEA or NetBeans

1. Clone the repository
```bash
git clone https://github.com/Deeghau0816/Travel-mainia.git
cd Travel-mainia
```

2. Create and populate the database
- Create a database (example name `travelmania`) and run the provided SQL script:
```bash
# from the repository root
mysql -u <db_user> -p < travelguid.sql
# or from mysql client
# CREATE DATABASE travelmania;
# USE travelmania;
# SOURCE path/to/tourguid.sql;
```
- Inspect `tourguid.sql` for table names, default users and seeded data.

3. Configure DB connection
- Locate where JDBC connection details are stored in the project (common places: `WEB-INF/web.xml`, a `db.properties` or inside a servlet/service class).

4. Build & deploy
- If the project is an Eclipse/IDE web project:
  - Import the project into Eclipse/IDE as a Dynamic Web Project or existing Maven/Gradle project (if present).
  - Add the MySQL connector to the project's libraries.
  - Run on a configured Tomcat server (Start server → publish project).
- If you prefer manual WAR:
  - Export a WAR from the IDE or package it with your build tool and copy it to Tomcat’s `webapps` directory.
  - Start Tomcat and open http://localhost:8080/<your-app-context>

Relevant file:
- tourguid.sql — https://github.com/Deeghau0816/Travel-mainia/blob/main/tourguid.sql

---

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

