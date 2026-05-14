# Car Rental Management System

A desktop-based Car Rental Management System developed using Java Swing and MySQL for efficient vehicle booking, customer management, and rental tracking.

## Overview

This project is a GUI-based desktop application designed to automate car rental operations. It provides separate functionalities for administrators and customers, allowing efficient booking management, vehicle handling, and secure authentication.

The application was developed using Java Swing for the frontend and MySQL for database management.

---

## Features

### Admin Functionalities
- Admin login authentication
- Add and manage vehicles
- View booking history
- Change password functionality
- Monitor customer bookings
- Manage rental records

### Customer Functionalities
- User registration and login
- Vehicle booking system
- Rental tracking
- Booking history management

### System Features
- GUI-based interface using Java Swing
- MySQL database integration
- CRUD operations
- Form validation
- Authentication system
- Database-driven record management

---

## Technologies Used

- Java
- Java Swing
- MySQL
- JDBC
- NetBeans IDE

---

## Concepts Implemented

- Object-Oriented Programming (OOP)
- Database Management System (DBMS)
- Exception Handling
- GUI Development
- Event Handling
- File and Record Management

---

## Project Structure

```text
src/        -> Java source files and GUI forms
images/     -> Application images and assets
libs/       -> External libraries and JDBC connectors
test/       -> Testing files
```

---

## How to Run the Project

1. Clone or download the repository
2. Open the project in NetBeans IDE
3. Configure MySQL database
4. Import the required SQL tables
5. Update database username and password in the source code
6. Run the project

---

## Database Requirements

- MySQL Server
- JDBC Connector

Example database connection:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/carrental",
    "root",
    "YOUR_PASSWORD"
);
```

---

## Future Improvements

- Online payment integration
- Cloud database support
- Email notifications
- Responsive UI enhancements
- Vehicle availability analytics

---

## Author

Divyam Arora
