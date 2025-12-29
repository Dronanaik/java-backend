<div align="center">

```
╔════════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                    ║
║     ██████╗ ██████╗ ███████╗███████╗ ██████╗██████╗ ██╗██████╗ ████████╗██╗ ██████╗ ███╗   ██╗     ║
║     ██╔══██╗██╔══██╗██╔════╝██╔════╝██╔════╝██╔══██╗██║██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║     ║
║     ██████╔╝██████╔╝█████╗  ███████╗██║     ██████╔╝██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║     ║
║     ██╔═══╝ ██╔══██╗██╔══╝  ╚════██║██║     ██╔══██╗██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║     ║
║     ██║     ██║  ██║███████╗███████║╚██████╗██║  ██║██║██║        ██║   ██║╚██████╔╝██║ ╚████║     ║
║     ╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝     ║
║                                                                                                    ║
║     ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗   ██╗████████╗   ║
║     ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝   ║
║     ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║█████╗  ██╔██╗ ██║   ██║      ║
║     ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║      ║
║     ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚████║   ██║      ║
║     ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝      ║
║                                                                                                    ║
╚════════════════════════════════════════════════════════════════════════════════════════════════════╝
```

# 💊 Prescription Management System

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-blue.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**An intelligent Spring Boot application for prescription management with drug interaction checks, allergy validation, and automated dosage calculations**

[Features](#-features) • [Tech Stack](#-tech-stack) • [Getting Started](#-getting-started) • [API Documentation](#-api-documentation) • [License](#-license)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Entities](#-entities)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Database Schema](#-database-schema)
- [License](#-license)

---

## 🎯 Overview

**Prescription Management System** is a comprehensive Spring Boot application designed for intelligent prescription management in healthcare settings. It provides advanced features including drug interaction warnings, allergy validation, automated dosage calculations based on patient demographics, refill authorization, and prescription expiry tracking.

This project demonstrates:
- Advanced healthcare prescription management
- Complex JPA entity relationships
- RESTful API design with specialized endpoints
- Service layer with intelligent business logic
- Patient safety features (drug interactions, allergy checks)

---

## ✨ Features

### 🔥 Core Features (The Big 5)

#### 1. 💊 Drug Interaction Check
- **Automatic detection** of dangerous drug combinations
- **Severity levels**: Minor, Moderate, Major, Contraindicated
- **Real-time warnings** when prescribing conflicting medications
- **Comprehensive database** of drug-drug interactions
- **Clinical recommendations** for healthcare providers

#### 2. 🚨 Allergy Validation
- **Patient allergy tracking** with severity levels (Mild, Moderate, Severe)
- **Automatic conflict detection** before prescribing
- **Allergen database** with symptoms and diagnosis dates
- **Safety alerts** to prevent allergic reactions
- **Historical allergy records** for patient safety

#### 3. 📊 Dosage Calculation
- **Intelligent dosage adjustment** based on patient age and weight
- **Pediatric dosing** (children under 12: 50% reduction)
- **Geriatric dosing** (elderly over 65: 25% reduction)
- **Weight-based adjustments** for patients significantly different from average (70kg)
- **Automated calculations** to ensure safe and effective dosing

#### 4. 🔄 Refill Authorization
- **Automated refill tracking** with remaining count
- **Expiry date validation** before authorizing refills
- **Prescription status checks** (Active, Completed, Cancelled, Expired)
- **Refill history logging** with timestamps
- **Authorization workflow** for controlled substances

#### 5. ⏰ Expiry Tracking
- **Automatic expiry date management** (default: 1 year from creation)
- **Expiring prescription alerts** with customizable timeframes
- **Patient-specific expiry reports** for proactive management
- **Status updates** when prescriptions expire
- **Renewal reminders** for continuous care

### 📦 Additional Features
- ✅ **Patient Management** - Complete patient demographics and medical history
- ✅ **Drug Catalog** - Comprehensive drug database with detailed information
- ✅ **Prescription Tracking** - Full prescription lifecycle management
- ✅ **RESTful APIs** - Complete CRUD operations for all entities
- ✅ **Data Validation** - Input validation and error handling

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 21 | Programming Language |
| **Spring Boot** | 4.0.1 | Application Framework |
| **Spring Data JPA** | 4.0.1 | Data Access Layer |
| **Hibernate** | (via Spring Boot) | ORM Framework |
| **MySQL** | 8.0+ | Relational Database |
| **Maven** | 4.0.0 | Build Tool |
| **Spring Boot DevTools** | 4.0.1 | Development Utilities |

---

## 📦 Entities

### 1. Patient
Represents patients in the system
- Demographics (name, age, weight, height, blood type)
- Medical history and contact information
- Relationship with allergies and prescriptions
- Used for dosage calculations

### 2. Drug
Represents medications in the catalog
- Drug information (name, generic name, manufacturer)
- Dosage form and strength
- Category, side effects, and contraindications
- Linked to prescriptions and interactions

### 3. Allergy
Tracks patient allergies
- Allergen identification
- Severity levels (Mild, Moderate, Severe)
- Diagnosis date and symptoms
- Patient relationship for validation

### 4. DrugInteraction
Manages drug-drug interactions
- Two-drug relationship tracking
- Severity levels (Minor, Moderate, Major, Contraindicated)
- Clinical effects and recommendations
- Used for safety checks

### 5. Prescription
Core prescription entity
- Patient and drug relationships
- Dosage, frequency, and duration
- Refill tracking (allowed, remaining)
- Status management (Active, Completed, Cancelled, Expired)
- Expiry date tracking

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 21** or higher
- **Maven 3.6+**
- **MySQL 8.0+** installed and running
- **Git** for cloning the repository

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Dronanaik/Java_Backend.git
   cd Java_Backend/PrescriptionManagement
   ```

2. **Create MySQL Database**
   ```bash
   mysql -u root -p
   ```
   
   Then execute:
   ```sql
   CREATE DATABASE prescription_db;
   EXIT;
   ```

3. **Configure Database Connection**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   ```

4. **Install Dependencies**
   ```bash
   mvn clean install
   ```

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Patient Endpoints
- `GET /patients` - Get all patients
- `GET /patients/{id}` - Get patient by ID
- `GET /patients/email/{email}` - Get patient by email
- `GET /patients/search?name={name}` - Search patients by name
- `GET /patients/blood-type/{bloodType}` - Get patients by blood type
- `POST /patients` - Create new patient
- `PUT /patients/{id}` - Update patient
- `DELETE /patients/{id}` - Delete patient

### Drug Endpoints
- `GET /drugs` - Get all drugs
- `GET /drugs/{id}` - Get drug by ID
- `GET /drugs/name/{name}` - Get drug by name
- `GET /drugs/category/{category}` - Get drugs by category
- `GET /drugs/search?term={term}` - Search drugs
- `GET /drugs/manufacturer/{manufacturer}` - Get drugs by manufacturer
- `POST /drugs` - Create new drug
- `PUT /drugs/{id}` - Update drug
- `DELETE /drugs/{id}` - Delete drug

### Allergy Endpoints
- `GET /allergies` - Get all allergies
- `GET /allergies/{id}` - Get allergy by ID
- `GET /allergies/patient/{patientId}` - Get allergies by patient
- `GET /allergies/severity/{severity}` - Get allergies by severity
- `GET /allergies/check?patientId={id}&drugName={name}` - **Check allergy conflict**
- `POST /allergies` - Create new allergy
- `PUT /allergies/{id}` - Update allergy
- `DELETE /allergies/{id}` - Delete allergy

### Drug Interaction Endpoints
- `GET /interactions` - Get all interactions
- `GET /interactions/{id}` - Get interaction by ID
- `GET /interactions/severity/{severity}` - Get interactions by severity
- `GET /interactions/between?drugId1={id1}&drugId2={id2}` - **Find interactions between drugs**
- `GET /interactions/drug/{drugId}` - Find all interactions for a drug
- `POST /interactions` - Create new interaction
- `PUT /interactions/{id}` - Update interaction
- `DELETE /interactions/{id}` - Delete interaction

### Prescription Endpoints

#### Standard CRUD
- `GET /prescriptions` - Get all prescriptions
- `GET /prescriptions/{id}` - Get prescription by ID
- `GET /prescriptions/patient/{patientId}` - Get prescriptions by patient
- `GET /prescriptions/status/{status}` - Get prescriptions by status
- `GET /prescriptions/expiring?daysAhead={days}` - Get expiring prescriptions
- `GET /prescriptions/refills-available` - Get prescriptions with refills available
- `POST /prescriptions` - Create new prescription
- `PUT /prescriptions/{id}` - Update prescription
- `DELETE /prescriptions/{id}` - Delete prescription

#### 🔥 Special Feature Endpoints

**1. Validate Prescription (Drug Interaction + Allergy Check)**
```http
POST /prescriptions/validate?patientId={id}&drugId={id}
```
Returns:
```json
{
  "isValid": true/false,
  "warnings": ["⚠️ ALLERGY ALERT: ...", "⚠️ DRUG INTERACTION: ..."],
  "patient": "Patient Name",
  "drug": "Drug Name"
}
```

**2. Calculate Dosage (Age + Weight Based)**
```http
POST /prescriptions/calculate-dosage?patientId={id}&drugId={id}&baseDosage=500mg
```
Returns:
```
"375mg (Calculated for age: 8, weight: 30.0kg)"
```

**3. Authorize Refill**
```http
POST /prescriptions/{id}/refill
```
Returns: Updated prescription with decremented refills

**4. Check Expiring Prescriptions for Patient**
```http
GET /prescriptions/patient/{patientId}/expiring?daysAhead=30
```
Returns: List of prescriptions expiring within specified days

---

## 🗄️ Database Schema

The application uses complex JPA relationships:

```
Patient (1) ────< (N) Allergy
Patient (1) ────< (N) Prescription >──── (1) Drug

Drug (1) ────< (N) Prescription
Drug (1) ────< (N) DrugInteraction >──── (1) Drug
```

**Key Relationships:**
- **Patient → Allergy**: One-to-Many (One patient can have multiple allergies)
- **Patient → Prescription**: One-to-Many (One patient can have multiple prescriptions)
- **Drug → Prescription**: One-to-Many (One drug can be prescribed multiple times)
- **Drug → DrugInteraction**: Many-to-Many (Drugs can interact with multiple other drugs)

**Tables Created:**
- `patients` - Patient demographics and medical history
- `drugs` - Drug catalog with detailed information
- `allergies` - Patient allergy records
- `prescriptions` - Prescription records with refill tracking
- `drug_interactions` - Drug-drug interaction warnings

---

## 📄 License

This project is licensed under the **MIT License**:

```
MIT License

Copyright (c) 2025 Java Backend Projects

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

<div align="center">

**⭐ If you find this project helpful, please consider giving it a star!**

Made with ❤️ using Spring Boot & Java

</div>
