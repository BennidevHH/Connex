# Connex Backend - pom.xml Guide

This pom.xml is fixed and version-locked for stable development.

## Key Dependencies

| Dependency | Purpose |
|-------------|----------|
| `spring-boot-starter-web` | REST API and MVC layer |
| `spring-boot-starter-security` | Authentication and JWT filter |
| `spring-boot-starter-data-jpa` | MySQL ORM layer |
| `spring-boot-starter-data-mongodb` | MongoDB document layer (chat messages) |
| `spring-boot-starter-validation` | Validation annotations (@NotNull, @Email, etc.) |
| `spring-boot-starter-websocket` | WebSocket (STOMP/SockJS) support |
| `mysql-connector-j` | JDBC driver for MySQL |
| `mapstruct` + `mapstruct-processor` | DTO mapping |
| `jjwt` | JSON Web Token handling |
| `testcontainers` | Integration testing with temporary databases |

## Java and Build Versions

- **Java:** 21
- **Spring Boot:** 3.3.0
- **MySQL Connector:** 8.4.0
- **MapStruct:** 1.5.5.Final
- **Testcontainers:** 1.19.8

## How to Use

1. Replace your existing backend/pom.xml with this version.
2. Run:
   ```bash
   mvn clean package -U
   ```
3. You should see `BUILD SUCCESS` if everything is configured correctly.

