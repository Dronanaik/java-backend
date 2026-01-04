<div align="center">

```
╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                   ║
║     ████████╗██████╗  █████╗ ███╗   ██╗███████╗ █████╗  ██████╗████████╗██╗ ██████╗ ███╗   ██╗    ║
║     ╚══██╔══╝██╔══██╗██╔══██╗████╗  ██║██╔════╝██╔══██╗██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║    ║
║        ██║   ██████╔╝███████║██╔██╗ ██║███████╗███████║██║        ██║   ██║██║   ██║██╔██╗ ██║    ║
║        ██║   ██╔══██╗██╔══██║██║╚██╗██║╚════██║██╔══██║██║        ██║   ██║██║   ██║██║╚██╗██║    ║
║        ██║   ██║  ██║██║  ██║██║ ╚████║███████║██║  ██║╚██████╗   ██║   ██║╚██████╔╝██║ ╚████║    ║
║        ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝    ║
║                                                                                                   ║
║     ██████╗ ██████╗  ██████╗  ██████╗███████╗███████╗███████╗██╗███╗   ██╗ ██████╗                ║
║     ██╔══██╗██╔══██╗██╔═══██╗██╔════╝██╔════╝██╔════╝██╔════╝██║████╗  ██║██╔════╝                ║
║     ██████╔╝██████╔╝██║   ██║██║     █████╗  ███████╗███████╗██║██╔██╗ ██║██║  ███╗               ║
║     ██╔═══╝ ██╔══██╗██║   ██║██║     ██╔══╝  ╚════██║╚════██║██║██║╚██╗██║██║   ██║               ║
║     ██║     ██║  ██║╚██████╔╝╚██████╗███████╗███████║███████║██║██║ ╚████║╚██████╔╝               ║
║     ╚═╝     ╚═╝  ╚═╝ ╚═════╝  ╚═════╝╚══════╝╚══════╝╚══════╝╚═╝╚═╝  ╚═══╝ ╚═════╝                ║
║                                                                                                   ║
╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝
```

# 💳 Transaction Processing System

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-blue.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**A comprehensive banking transaction processing system with daily limits, fraud detection, currency conversion, and automated payment features**

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

**Transaction Processing System** is an enterprise-grade Spring Boot application designed for comprehensive banking transaction management. It implements 8 core features essential for modern financial systems including transaction limits, fraud detection, multi-currency support, and automated payment processing.

This project demonstrates:
- Advanced transaction processing with multiple validation layers
- Real-time fraud detection with configurable rules
- Multi-currency transaction support with live exchange rates
- Automated recurring payments and standing instructions
- Enterprise-level service architecture and design patterns

---

## ✨ Features

### 🔥 Core Features (The Big 8)

#### 1. 💰 Daily Transaction Limits
- **Configurable limits** per account
- **Real-time tracking** of daily transaction totals
- **Automatic enforcement** before transaction processing
- **Limit status API** to check remaining daily allowance
- **Account-level customization** for different account types

#### 2. 🚨 Fraud Detection Rules
- **Configurable fraud rules** with multiple detection types
- **Amount threshold detection** for unusually large transactions
- **Frequency pattern analysis** to detect rapid transaction sequences
- **Severity levels**: Low, Medium, High, Critical
- **Automated alerting** with review workflow
- **Rule management** - activate/deactivate rules dynamically

#### 3. 💱 Currency Conversion
- **Real-time exchange rate** application
- **Multi-currency account** support
- **Automatic conversion** for cross-currency transactions
- **Exchange rate management** with manual or API updates
- **Conversion history** tracking with applied rates

#### 4. 🔄 Transaction Reversal Logic
- **Complete reversal** of completed transactions
- **Balance restoration** for both accounts
- **Fee refund** included in reversal
- **Audit trail** with reversal reasons
- **Status tracking** (COMPLETED → REVERSED)

#### 5. 📅 Standing Instructions
- **Automated recurring transfers** on specific dates
- **Flexible frequency**: Daily, Weekly, Monthly, Yearly
- **Execution day** configuration
- **Start and end date** management
- **Automatic execution** with status tracking
- **Pause/resume** functionality

#### 6. 📝 Bill Payment Scheduling
- **Recurring bill payment** automation
- **Due date tracking** with reminders
- **Auto-pay** enablement per bill
- **Biller management** with codes
- **Payment history** tracking
- **Failed payment** handling and retry

#### 7. ⚠️ Insufficient Funds Check
- **Pre-transaction validation** of account balance
- **Automatic rejection** when funds are insufficient
- **Fee inclusion** in balance check
- **Real-time balance** verification
- **Transaction failure** logging with reason

#### 8. 💵 Transaction Fee Calculation
- **Multiple fee types**: Flat, Percentage, Tiered
- **Transaction-type specific** fee rules
- **Min/max fee** limits
- **Currency-specific** fee configuration
- **Automatic application** during transaction processing
- **Fee transparency** in transaction records

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

### 1. Account
Represents bank accounts in the system
- Account details (number, holder name, type, currency)
- Balance tracking and daily limits
- Account status management (ACTIVE/FROZEN/CLOSED)
- Relationships with transactions and payments

### 2. Transaction
Core transaction entity for all financial operations
- Transaction types (WITHDRAWAL/TRANSFER/DEPOSIT/PAYMENT)
- Amount, currency, and exchange rate tracking
- Status management (PENDING/COMPLETED/FAILED/REVERSED)
- Fee and reversal information

### 3. FraudRule
Configurable fraud detection rules
- Rule types (AMOUNT_THRESHOLD/FREQUENCY/PATTERN)
- Threshold and time window configuration
- Severity levels and activation status
- Linked to fraud alerts

### 4. FraudAlert
Fraud alerts for flagged transactions
- Transaction and rule relationships
- Alert severity and status tracking
- Review workflow with notes
- Timestamp tracking

### 5. ExchangeRate
Currency exchange rate management
- Currency pair definitions
- Rate values with effective dates
- Source tracking (MANUAL/API)
- Historical rate tracking

### 6. StandingInstruction
Recurring transfer automation
- Account relationships (from/to)
- Frequency and execution day configuration
- Status and execution tracking
- Next execution calculation

### 7. BillPayment
Bill payment scheduling and automation
- Biller information and codes
- Due date and frequency management
- Auto-pay configuration
- Payment history tracking

### 8. TransactionFeeRule
Fee calculation rule configuration
- Transaction type specific rules
- Fee types (FLAT/PERCENTAGE/TIERED)
- Min/max amount limits
- Currency-specific configuration

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
   cd Java_Backend/TransactionProcessing
   ```

2. **Create MySQL Database**
   ```bash
   mysql -u root -p
   ```
   
   Then execute:
   ```sql
   CREATE DATABASE transaction_db;
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

### Account Endpoints
- `GET /accounts` - Get all accounts
- `GET /accounts/{id}` - Get account by ID
- `GET /accounts/number/{accountNumber}` - Get account by number
- `GET /accounts/{id}/balance` - Check account balance
- `GET /accounts/{id}/daily-limit-status` - **Check daily limit usage** (Feature 1)
- `POST /accounts` - Create new account
- `PUT /accounts/{id}` - Update account
- `DELETE /accounts/{id}` - Delete account

### Transaction Endpoints
- `GET /transactions` - Get all transactions
- `GET /transactions/{id}` - Get transaction by ID
- `POST /transactions/process` - **Process new transaction** (All features)
- `POST /transactions/{id}/reverse` - **Reverse transaction** (Feature 4)
- `GET /transactions/account/{accountId}` - Get transactions by account
- `GET /transactions/status/{status}` - Get transactions by status
- `GET /transactions/date-range` - Get transactions by date range

### Fraud Detection Endpoints
- `GET /fraud/rules` - Get all fraud rules
- `POST /fraud/rules` - **Create fraud rule** (Feature 2)
- `PUT /fraud/rules/{id}` - Update fraud rule
- `GET /fraud/alerts` - Get all fraud alerts
- `GET /fraud/alerts/pending` - Get pending alerts
- `PUT /fraud/alerts/{id}/review` - Review fraud alert

### Currency Conversion Endpoints
- `GET /currency/rates` - Get all exchange rates
- `GET /currency/convert?amount={amount}&from={from}&to={to}` - **Convert currency** (Feature 3)
- `GET /currency/rate?from={from}&to={to}` - Get exchange rate
- `POST /currency/rates` - Add/update exchange rate

### Standing Instruction Endpoints
- `GET /standing-instructions` - Get all instructions
- `POST /standing-instructions` - **Create standing instruction** (Feature 5)
- `PUT /standing-instructions/{id}` - Update instruction
- `POST /standing-instructions/execute-due` - Execute due instructions
- `GET /standing-instructions/account/{accountId}` - Get by account

### Bill Payment Endpoints
- `GET /bills` - Get all bill payments
- `POST /bills` - **Schedule bill payment** (Feature 6)
- `GET /bills/due?daysAhead={days}` - Get upcoming bills
- `POST /bills/{id}/pay` - Process bill payment
- `POST /bills/process-due` - Process all due bills
- `GET /bills/account/{accountId}` - Get bills by account

### Fee Calculation Endpoints
- `GET /fees/rules` - Get all fee rules
- `POST /fees/rules` - Create fee rule
- `POST /fees/calculate` - **Calculate fee for transaction** (Feature 8)
- `GET /fees/rules/type/{transactionType}` - Get fee rules by type

---

## 🗄️ Database Schema

The application uses complex JPA relationships:

```
Account (1) ────< (N) Transaction (from/to accounts)
Account (1) ────< (N) StandingInstruction
Account (1) ────< (N) BillPayment

Transaction (1) ────< (N) FraudAlert >──── (1) FraudRule

ExchangeRate (N) - Currency pair tracking
TransactionFeeRule (N) - Fee configuration
```

**Key Relationships:**
- **Account → Transaction**: One-to-Many (One account can have multiple transactions)
- **Transaction → FraudAlert**: One-to-Many (One transaction can trigger multiple alerts)
- **FraudRule → FraudAlert**: One-to-Many (One rule can generate multiple alerts)
- **Account → StandingInstruction**: One-to-Many (One account can have multiple instructions)
- **Account → BillPayment**: One-to-Many (One account can have multiple bills)

**Tables Created:**
- `accounts` - Bank account information
- `transactions` - All financial transactions
- `fraud_rules` - Fraud detection configuration
- `fraud_alerts` - Flagged transaction alerts
- `exchange_rates` - Currency conversion rates
- `standing_instructions` - Recurring transfer automation
- `bill_payments` - Bill payment scheduling
- `transaction_fee_rules` - Fee calculation rules

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
