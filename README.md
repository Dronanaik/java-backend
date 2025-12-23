<div align="center">

<pre style="color: #1E90FF; font-weight: bold;">
╔══════════════════════════════════════════════════════════════════════════════╗
║                                                                              ║
║         ██╗ █████╗ ██╗   ██╗ █████╗                                          ║
║         ██║██╔══██╗██║   ██║██╔══██╗                                         ║
║         ██║███████║██║   ██║███████║                                         ║
║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║                                         ║
║    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║                                         ║
║     ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝                                         ║
║                                                                              ║
║         ██████╗  █████╗  ██████╗██╗  ██╗███████╗███╗   ██╗██████╗            ║
║         ██╔══██╗██╔══██╗██╔════╝██║ ██╔╝██╔════╝████╗  ██║██╔══██╗           ║
║         ██████╔╝███████║██║     █████╔╝ █████╗  ██╔██╗ ██║██║  ██║           ║
║         ██╔══██╗██╔══██║██║     ██╔═██╗ ██╔══╝  ██║╚██╗██║██║  ██║           ║
║         ██████╔╝██║  ██║╚██████╗██║  ██╗███████╗██║ ╚████║██████╔╝           ║
║         ╚═════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝╚═════╝            ║
║                                                                              ║
╚══════════════════════════════════════════════════════════════════════════════╝
</pre>

# ☕ Java Backend Projects Repository

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-blue.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**A curated collection of Java backend projects demonstrating Spring Boot, JPA, RESTful APIs, and enterprise patterns**

[Projects](#-projects) • [Getting Started](#-getting-started) • [Contributing](#-contributing) • [License](#-license) • [Connect](#-connect-with-me)

</div>

---

## 📋 Table of Contents

- [☕ Java Backend Projects Repository](#-java-backend-projects-repository)
  - [📋 Table of Contents](#-table-of-contents)
  - [🎯 Overview](#-overview)
  - [📂 Projects](#-projects)
    - [1️⃣ Entity Mapping](#1️⃣-entity-mapping)
  - [🛠️ Common Tech Stack](#️-common-tech-stack)
  - [🚀 Getting Started](#-getting-started)
    - [Prerequisites](#prerequisites)
    - [Quick Start](#quick-start)
    - [General Setup Pattern](#general-setup-pattern)
  - [🤝 Contributing](#-contributing)
  - [📄 License](#-license)
  - [🌐 Connect With Me](#-connect-with-me)
  - [📞 Contact \& Support](#-contact--support)

---

## 🎯 Overview

Welcome to my **Java Backend Projects** repository! This is a comprehensive collection of Spring Boot applications showcasing various backend development concepts, patterns, and best practices. Each project is designed to demonstrate specific aspects of enterprise Java development.

This repository serves as a practical reference for:
- Spring Boot application development
- JPA/Hibernate entity relationships and ORM
- RESTful API design and implementation
- Service layer architecture and design patterns
- Database integration and management
- Enterprise Java best practices

---

## 📂 Projects

### 1️⃣ [Entity Mapping](./EntityMapping)

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)

**A comprehensive Spring Boot application demonstrating JPA entity relationships and RESTful API design**

**Key Features:**
- ✅ Complete CRUD operations for multiple entities
- ✅ JPA entity relationships (One-to-Many, Many-to-One)
- ✅ RESTful API endpoints with proper HTTP methods
- ✅ Service layer pattern with interface-based design
- ✅ MySQL database integration with automatic schema generation
- ✅ Cascade operations for related entities

**Entities:** Customer, Contact, Deal, Lead, Note, Company

**Tech Stack:** Java 21, Spring Boot 4.0.1, Spring Data JPA, MySQL, Maven

[📖 View Project Documentation](./EntityMapping/README.md)

---

## 🛠️ Common Tech Stack

All projects in this repository utilize modern Java backend technologies:

| Technology | Purpose |
|------------|---------|
| **Java 21** | Programming Language |
| **Spring Boot** | Application Framework |
| **Spring Data JPA** | Data Access Layer |
| **Hibernate** | ORM Framework |
| **MySQL / PostgreSQL** | Relational Databases |
| **Maven** | Build & Dependency Management |
| **Spring Boot DevTools** | Development Utilities |
| **JUnit & Mockito** | Testing Frameworks |

---

## 🚀 Getting Started

### Prerequisites

Before working with any project in this repository, ensure you have:

- **Java Development Kit (JDK) 21** or higher
  ```bash
  java -version
  ```

- **Maven 3.6+** (or use the included Maven wrapper in each project)
  ```bash
  mvn -version
  ```

- **MySQL 8.0+** or **PostgreSQL** (depending on the project)
  ```bash
  mysql --version
  ```

- **Git** for cloning the repository
  ```bash
  git --version
  ```

- **Your favorite IDE** (IntelliJ IDEA, Eclipse, VS Code, etc.)

---

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/Dronanaik/Java_Backend.git
   cd Java_Backend
   ```

2. **Navigate to a specific project**
   ```bash
   cd EntityMapping
   ```

3. **Follow the project-specific README**
   
   Each project has its own detailed README with:
   - Setup instructions
   - Configuration details
   - API documentation
   - Running instructions
   
   Example: [EntityMapping README](./EntityMapping/README.md)

---

### General Setup Pattern

Most projects follow this pattern:

1. **Create Database**
   ```sql
   CREATE DATABASE project_name;
   ```

2. **Configure `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

For specific instructions, refer to each project's README file.

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License** - see below for details:

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

## 🌐 Connect With Me

<div align="center">

[![GitHub](https://img.shields.io/badge/GitHub-Dronanaik-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Dronanaik)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Drona_L-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/drona-l/)
[![Twitter](https://img.shields.io/badge/Twitter-@drona__l-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://x.com/drona_l)
[![Instagram](https://img.shields.io/badge/Instagram-@spotter__naik-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/spotter_naik/)

</div>

---

## 📞 Contact & Support

For questions, suggestions, or support:
- 📧 Open an issue in this repository
- 💬 Reach out via social media links above
- 🤝 Submit a pull request for improvements

---

<div align="center">

**⭐ If you find these projects helpful, please consider giving them a star!**

Made with ❤️ using Spring Boot & Java

</div>
