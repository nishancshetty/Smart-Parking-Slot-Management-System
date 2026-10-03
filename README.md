# Smart Parking Slot Management System

A **Java-based console application** that automates parking lot operations by managing vehicle entry, slot allocation, ticket generation, fee calculation, and transaction records.

---

## Features

* Automatic parking slot allocation
* Supports multiple vehicle types (Bike, Car, SUV, EV)
* Parking ticket generation
* Parking fee calculation based on duration
* Vehicle search using registration number
* Live parking slot status
* Transaction history
* File-based data storage

---

## Tech Stack

* Java
* Object-Oriented Programming (OOP)
* Java Collections
* File Handling
* LocalDateTime
* Git & GitHub

---

## Project Structure

```text
Group-Project/
│
├── com/
│   └── parking/        # Java source files
│
├── data/               # Parking & transaction records
│
└── README.md
```

---

## How It Works

```text
Vehicle Enters
      │
      ▼
Automatic Slot Allocation
      │
      ▼
Ticket Generated
      │
      ▼
Vehicle Parked
      │
      ▼
Vehicle Exit
      │
      ▼
Fee Calculated
      │
      ▼
Transaction Saved
```

---

## Installation

```bash
git clone https://github.com/nishancshetty/Group-Project.git
cd Group-Project
```

Compile the project:

```bash
javac com/parking/*.java
```

Run the application:

```bash
java com.parking.Main
```

> Replace `Main` with the class that contains the `main()` method if required.

---

## Key Concepts Demonstrated

* Object-Oriented Programming
* Encapsulation
* Inheritance
* Polymorphism
* Enums
* File Handling
* Exception Handling
* Modular Programming

---

## Future Improvements

* Database Integration
* GUI/Desktop Application
* Web Dashboard
* QR Code Tickets
* Online Reservations
* Digital Payments

---

## Team

Developed as a **Group Project** to demonstrate practical implementation of Java and Object-Oriented Programming concepts.
