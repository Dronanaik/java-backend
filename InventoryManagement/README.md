<div align="center">

```
╔════════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                    ║
║     ██╗███╗   ██╗██╗   ██╗███████╗███╗   ██╗████████╗ ██████╗ ██████╗██╗   ██╗                     ║
║     ██║████╗  ██║██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝                    ║
║     ██║██╔██╗ ██║██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║██████╔╝ ╚████╔╝                     ║
║     ██║██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝                      ║
║     ██║██║ ╚████║ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝██║  ██║   ██║                       ║
║     ╚═╝╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝                       ║
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

# 📦 Inventory Management System

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-blue.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**A comprehensive Spring Boot application for multi-warehouse inventory management with advanced tracking and analytics**

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

**Inventory Management System** is an enterprise-grade Spring Boot application designed for comprehensive inventory tracking across multiple warehouses. It provides complete functionality for managing products, stock levels, suppliers, purchases, sales, and inter-warehouse transfers with advanced features like batch tracking, expiry management, and inventory valuation.

This project demonstrates:
- Multi-warehouse inventory management
- Complex JPA entity relationships
- RESTful API design with comprehensive endpoints
- Service layer architecture with business logic
- Advanced querying and reporting capabilities

---

## ✨ Features

### Core Features
- ✅ **Multi-Warehouse Support** - Track inventory across multiple warehouse locations
- ✅ **Product Management** - Comprehensive product catalog with SKU and barcode support
- ✅ **Stock Tracking** - Real-time stock levels with batch and lot number tracking
- ✅ **Supplier Management** - Vendor management with ratings and payment terms
- ✅ **Purchase Orders** - Complete purchase order lifecycle management
- ✅ **Sales Orders** - Sales order processing with payment tracking
- ✅ **Stock Transfers** - Inter-warehouse stock transfer with approval workflow

### Advanced Features
- 📊 **Inventory Valuation** - Support for FIFO, LIFO, and Average costing methods
- 📅 **Expiry Tracking** - Batch and expiry date management for perishable goods
- 🔔 **Low Stock Alerts** - Automatic alerts when stock falls below reorder levels
- 📈 **Analytics Ready** - Date range queries for reporting and forecasting
- 🏷️ **Barcode/QR Support** - Product identification via barcode scanning
- 💰 **Financial Tracking** - Cost price, selling price, and profit margin tracking

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

### 1. Product
Represents items in the inventory system
- Product information (name, SKU, barcode, description)
- Pricing (cost price, selling price)
- Category and unit of measurement
- Reorder level for low stock alerts

### 2. Warehouse
Represents storage locations
- Warehouse identification (code, name)
- Location details (address, city, state, country)
- Contact information
- Capacity tracking
- Active/inactive status

### 3. Stock
Tracks inventory levels in warehouses
- Product-warehouse relationship
- Quantity tracking
- Batch and lot number
- Expiry and manufacturing dates
- Valuation method (FIFO/LIFO/Average)

### 4. Supplier
Manages vendor information
- Supplier details (code, name, contact)
- Payment terms and credit limit
- Rating system (1-5 stars)
- Active/inactive status

### 5. Purchase
Purchase order management
- Order tracking (PO number, dates)
- Supplier and product relationship
- Quantity and pricing
- Order status (Pending, Confirmed, Shipped, Delivered, Cancelled)
- Batch and expiry tracking

### 6. Sale
Sales order processing
- Order tracking (SO number, dates)
- Customer information
- Quantity, pricing, discount, and tax
- Payment status (Unpaid, Partially Paid, Paid, Refunded)
- Order status (Pending, Confirmed, Processing, Shipped, Delivered, Cancelled, Returned)

### 7. Transfer
Inter-warehouse stock transfers
- Transfer tracking (transfer number, dates)
- Source and destination warehouses
- Product and quantity
- Transfer status (Pending, Approved, In Transit, Received, Cancelled, Rejected)
- Approval workflow (initiated by, approved by, received by)

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
   cd Java_Backend/InventoryManagement
   ```

2. **Create MySQL Database**
   ```bash
   mysql -u root -p
   ```
   
   Then execute:
   ```sql
   CREATE DATABASE inventory_management;
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

### Product Endpoints
- `GET /products` - Get all products
- `GET /products/{id}` - Get product by ID
- `GET /products/sku/{sku}` - Get product by SKU
- `GET /products/barcode/{barcode}` - Get product by barcode
- `GET /products/category/{category}` - Get products by category
- `GET /products/search?name={name}` - Search products by name
- `POST /products` - Create new product
- `PUT /products/{id}` - Update product
- `DELETE /products/{id}` - Delete product

### Warehouse Endpoints
- `GET /warehouses` - Get all warehouses
- `GET /warehouses/{id}` - Get warehouse by ID
- `GET /warehouses/code/{code}` - Get warehouse by code
- `GET /warehouses/active` - Get active warehouses
- `GET /warehouses/city/{city}` - Get warehouses by city
- `POST /warehouses` - Create new warehouse
- `PUT /warehouses/{id}` - Update warehouse
- `DELETE /warehouses/{id}` - Delete warehouse

### Stock Endpoints
- `GET /stocks` - Get all stocks
- `GET /stocks/{id}` - Get stock by ID
- `GET /stocks/product/{productId}` - Get stocks by product
- `GET /stocks/warehouse/{warehouseId}` - Get stocks by warehouse
- `GET /stocks/product/{productId}/warehouse/{warehouseId}` - Get stock by product and warehouse
- `GET /stocks/expiring?beforeDate={date}` - Get expiring stocks
- `GET /stocks/low-stock` - Get low stock items
- `POST /stocks` - Create new stock
- `PUT /stocks/{id}` - Update stock
- `DELETE /stocks/{id}` - Delete stock

### Supplier Endpoints
- `GET /suppliers` - Get all suppliers
- `GET /suppliers/{id}` - Get supplier by ID
- `GET /suppliers/code/{code}` - Get supplier by code
- `GET /suppliers/active` - Get active suppliers
- `GET /suppliers/rating/{rating}` - Get suppliers by rating
- `POST /suppliers` - Create new supplier
- `PUT /suppliers/{id}` - Update supplier
- `DELETE /suppliers/{id}` - Delete supplier

### Purchase Endpoints
- `GET /purchases` - Get all purchases
- `GET /purchases/{id}` - Get purchase by ID
- `GET /purchases/order/{orderNumber}` - Get purchase by order number
- `GET /purchases/supplier/{supplierId}` - Get purchases by supplier
- `GET /purchases/status/{status}` - Get purchases by status
- `GET /purchases/date-range?startDate={start}&endDate={end}` - Get purchases by date range
- `POST /purchases` - Create new purchase
- `PUT /purchases/{id}` - Update purchase
- `DELETE /purchases/{id}` - Delete purchase

### Sale Endpoints
- `GET /sales` - Get all sales
- `GET /sales/{id}` - Get sale by ID
- `GET /sales/order/{orderNumber}` - Get sale by order number
- `GET /sales/status/{status}` - Get sales by status
- `GET /sales/payment-status/{paymentStatus}` - Get sales by payment status
- `GET /sales/date-range?startDate={start}&endDate={end}` - Get sales by date range
- `GET /sales/customer?name={name}` - Search sales by customer name
- `POST /sales` - Create new sale
- `PUT /sales/{id}` - Update sale
- `DELETE /sales/{id}` - Delete sale

### Transfer Endpoints
- `GET /transfers` - Get all transfers
- `GET /transfers/{id}` - Get transfer by ID
- `GET /transfers/number/{transferNumber}` - Get transfer by number
- `GET /transfers/from-warehouse/{warehouseId}` - Get transfers from warehouse
- `GET /transfers/to-warehouse/{warehouseId}` - Get transfers to warehouse
- `GET /transfers/status/{status}` - Get transfers by status
- `POST /transfers` - Create new transfer
- `PUT /transfers/{id}` - Update transfer
- `DELETE /transfers/{id}` - Delete transfer

---

## 🗄️ Database Schema

The application uses complex JPA relationships:

```
Product (1) ────< (N) Stock >──── (1) Warehouse
                    │
Supplier (1) ────< (N) Purchase >──── (1) Product
                                 >──── (1) Warehouse

Product (1) ────< (N) Sale >──── (1) Warehouse

Product (1) ────< (N) Transfer
Warehouse (1) ──< (N) Transfer (from)
Warehouse (1) ──< (N) Transfer (to)
```

**Key Relationships:**
- **Product → Stock**: One-to-Many (One product can exist in multiple warehouses)
- **Warehouse → Stock**: One-to-Many (One warehouse can store multiple products)
- **Supplier → Purchase**: One-to-Many (One supplier can have multiple purchase orders)
- **Product → Purchase/Sale/Transfer**: One-to-Many relationships for tracking

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
