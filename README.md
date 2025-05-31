# Appointments API

This project is a REST API web application for appointment management, built with Java and Spring Boot.

## Prerequisites

- Java 17+
- Maven 3.8+

## Setup & Run

```bash
mvn clean install
mvn spring-boot:run
```

## Sample Request

```bash
curl http://localhost:8080/appointments
```

## Run Tests

```bash
mvn test
```

## Postman Collection

See `postman/appointments.postman_collection.json` for API testing.

## API Documentation

- [Swagger UI](http://localhost:8080/swagger-ui.html)
- See `docs/appointments-diagram.md` for API diagram
- See `docs/icd.md` for interface details

## Project Structure

- `src/main/java/com/example/appointments/` - Main source code
- `src/test/java/com/example/appointments/` - Tests
- `datadog/` - Datadog monitors
- `docs/` - Documentation
- `postman/` - Postman collections

---

For more details, see `copilot-instructions.md`.
