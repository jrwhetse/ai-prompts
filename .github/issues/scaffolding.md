---
title: Scaffolding
assignees:
  - CoPilot
description: |
  # Copilot Instructions

  This project is a web application that allows users to view their appointments.
  It is built using Java and Spring Boot.
  It is a Maven application—use `pom.xml` to manage dependencies.

  ## 🧠 Context

  - **Project Type**: REST API web application for appointment management
  - **Language**: Java
  - **Framework / Libraries**: Spring Boot, JUnit 5, Mockito, Swagger/OpenAPI
  - **Architecture**: Layered (Controller, Service, Repository, DTO, Entity), MVC

  **When adding dependencies or libraries:**
  - Always add dependencies to the `pom.xml` file.
  - Use the latest stable versions compatible with Spring Boot.
  - Prefer official, community-supported libraries.
  - For testing, use JUnit 5 and Mockito.
  - For API documentation, use Swagger/OpenAPI (`springdoc-openapi`).
  - For logging, use SLF4J with Logback. Avoid using 'System.out.println()' for logging.
  - Do not use deprecated or unmaintained libraries.

  ## 🔧 General Guidelines

  - Use Java-idiomatic patterns and best practices.
  - Prefer readability over cleverness.
  - Use Lombok annotations (e.g., @Getter, @Setter, @Slf4j) to reduce boilerplate, but avoid annotations like @Data, or any others that generate methods not explicitly required or exercised (e.g., equals, hashCode, toString). This helps prevent inflated code paths and preserves the accuracy of test coverage metrics. Only generate methods that are actually needed and used.
  - Prefer Lombok for DTOs, POJOs, and logging instead of writing boilerplate code manually.
  - Each class will be placed in its own file, following the standard Java convention and your project structure.
  - Configuration fields (like @Value and @Autowired) will be placed at the top of the class, after the class declaration and before methods, not in the middle or bottom.
  - No nested classes inside service or other classes; all DTOs and helper classes will be in their own files in the appropriate package (e.g., dto).
  - For every code change (new feature, method, or update), always create or update corresponding unit and/or integration tests. This is required even if the prompt does not explicitly mention tests. Code changes without tests are not permitted.

  ## Java Coding Standards

  - Use camelCase for variable, method, and parameter names.
  - Use PascalCase for class and interface names.
  - Use 4 spaces for indentation.
  - Use braces `{}` for all code blocks, even single-line blocks.
  - Use `final` for constants and variables that should not be reassigned.
  - Use descriptive names for classes, methods, and variables.
  - Place each class in its own file.
  - Use Javadoc comments for public classes and methods.
  - Organize imports: standard Java, third-party, then project-specific. Avoid wildcard imports.
  - Keep lines under 120 characters.
  - Use annotations (e.g., `@Override`, `@RestController`) where appropriate.
  - Follow standard Java conventions for spacing and formatting.
  - Include short, helpful code comments only when necessary to explain complex code; avoid excessive or redundant comments. Comment on the "why" rather than the "how".
  - Constants should be UPPER_SNAKE_CASE.
  - Prefer explicit types for local variables instead of var. This ensures clarity, compatibility, and consistency across the codebase.

  ... (truncated for brevity, see copilot-instructions.md for full content)
