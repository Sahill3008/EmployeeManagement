# Employee Management System (EMS)

A web-based Java application designed to manage employee records efficiently. This system provides role-based access control (Admin and Employee), database persistence using Hibernate/JPA, and performance optimization via second-level caching.

## 🚀 Features

* **User Authentication**: Secure Login and Logout functionality.
* **Role-Based Access Control (RBAC)**:
    * **Admin**: Full access to manage the system. Can View, Add, Update, Delete, and Search employees.
    * **Employee**: Restricted access. Can view their own dashboard and manage their own profile.
* **Employee Management**: comprehensive CRUD (Create, Read, Update, Delete) operations for employee records.
* **Search Functionality**: Ability to search for specific employees.
* **Profile Management**: Employees can view and edit their personal profile details.
* **Performance Optimization**: Integrated **Ehcache** (Hibernate Second Level Cache) to reduce database load and improve response times.
* **Security**: `AuthFilter` implementation to protect unauthorized access to application resources.

## 🛠️ Tech Stack

* **Language**: Java 8
* **Web Framework**: Servlets 3.1, JSP 2.3
* **ORM / Persistence**: Hibernate 5.4 (JPA 2.1 Standard)
* **Database**: PostgreSQL
* **Caching**: Ehcache 2.10
* **Build Tool**: Maven
* **Frontend**: JSP, JSTL, HTML/CSS

## ⚙️ Prerequisites

Ensure you have the following installed on your local machine:
1.  **Java Development Kit (JDK) 1.8**
2.  **Apache Maven**
3.  **PostgreSQL Database**
4.  **Apache Tomcat** (or any standard Servlet Container)

## 📥 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/Sahill3008/EmployeeManagement
cd employee-management-system
2. Database Configuration
Open your PostgreSQL client (pgAdmin or command line).

Create a new database named emsdb.

SQL

CREATE DATABASE emsdb;
(Optional) The application is configured to automatically update the schema (hibernate.hbm2ddl.auto is set to update).

3. Configure Database Credentials
Open src/main/resources/META-INF/persistence.xml and update the connection properties if your local PostgreSQL credentials differ from the defaults:

XML

<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/emsdb" />
<property name="javax.persistence.jdbc.user" value="postgres" />
<property name="javax.persistence.jdbc.password" value="root" />
4. Build the Project
Navigate to the project root directory and run:

Bash

mvn clean install
This will generate a WAR file in the target/ directory (e.g., employee-management-system.war).

5. Deploy and Run
Copy the generated .war file to the webapps folder of your Tomcat installation.

Start the Tomcat server.

Access the application in your browser at:

http://localhost:8080/employee-management-system
📂 Project Structure
employee-management-system/
├── src/main/java/com/ems/
│   ├── controller/      # Servlets (Login, Employee, Profile, Logout)
│   ├── dao/             # Data Access Objects
│   ├── filter/          # Authentication Filter (AuthFilter)
│   ├── model/           # JPA Entities (Employee)
│   ├── service/         # Business Logic Layer
│   └── util/            # Utility classes (JPAUtil)
├── src/main/resources/
│   ├── META-INF/
│   │   └── persistence.xml  # Database & Hibernate Configuration
│   └── ehcache.xml          # Caching Configuration
├── src/main/webapp/
│   ├── WEB-INF/
│   │   └── web.xml          # Deployment Descriptor
│   ├── dashboard.jsp        # User Dashboard
│   ├── dashboard-admin.jsp  # Admin Dashboard
│   ├── login.jsp            # Login Page
│   └── ...                  # Other JSPs (forms, lists, errors)
└── pom.xml                  # Maven Dependencies
👤 User Roles & default Usage
The system supports two distinct roles defined in the Employee entity:

ADMIN: Access to dashboard-admin.jsp. Has control over the entire employee directory.

EMPLOYEE: Access to dashboard.jsp. Can only view/edit their own data.

Note: You may need to manually insert an initial Admin user into the database or use a registration feature if available to gain initial access.
