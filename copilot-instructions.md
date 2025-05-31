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

## 📁 File Structure

Use this structure as a guide when creating or updating files:

```
src/
  main/
    java/
      com/[ProjectName]/[module]/
        controller/
        service/
        dto/
  test/
    java/
      com/[ProjectName]/[module]/
        controller/
        service/
        ...
datadog/
  [module]/
    [endpoint]-monitor.json
docs/
  [name]-diagram.md
  icd.md
  README.md
postman/
  [name].postman_collection.json
prompt-history/
  prompt-history.md
```

## 🧶 Patterns

### ✅ Patterns to Follow
- Organize code by layer and feature
- Use Dependency Injection for services and repositories.
- Use Repository Pattern for data access.
- For APIs:
  - Input validation using Java Bean Validation (e.g., `@Valid`, `@NotNull`).
  - Error handling using custom exceptions and status codes.
  - Logging via SLF4J or similar logging frameworks.
  - Ensure Swagger/OpenAPI documentation is kept up to date as controllers are added or changed.
- Always accompany new or changed code with appropriate tests in the correct test package.

### 🚫 Patterns to Avoid
- Don't generate code without tests.
- Never submit or commit code changes without corresponding tests.
- Avoid global state unless absolutely necessary.
- Don't expose secrets or keys.
- Avoid SELECT * in queries; specify fields explicitly.
- Don't use wildcard imports.
- Don't include unnecessary or redundant comments.

## Exception Handling

- Handle exceptions explicitly.
- Catch and assert exceptions in tests using `assertThrows`.
- Use custom exceptions (e.g., `[ProjectName]RuntimeException`) for business logic errors.

## API Design & Documentation

- Annotate all Java REST endpoints with Swagger/OpenAPI annotations (e.g., `@Operation`, `@ApiResponse`, `@Tag`) to generate API documentation.
- Use WebClient instead of RestTemplate for making external API calls.
- Avoid generic types whenever possible; use specific DTOs for clarity.
- Ensure Swagger/OpenAPI documentation is kept up to date as controllers are added or changed.
- When adding or updating error handling in API controllers, always update Swagger/OpenAPI annotations to document error responses (e.g., @ApiResponse for 500 errors) so the API documentation remains accurate.
- Whenever possible, implement robust error handling in your code to ensure reliable, fault-tolerant API controllers. Use appropriate exception handling, return meaningful error responses, and log errors for troubleshooting.

## Testing Guidelines

- Use JUnit 5 and Mockito for unit tests.
- Write tests using JUnit 5 annotations (`@Test`, `@BeforeEach`, `@ExtendWith(MockitoExtension.class)`, etc.).
- Use Mockito for mocking dependencies and `@InjectMocks` for the service under test.
- Use `@MockitoSettings(strictness = Strictness.LENIENT)` where needed.
- For every code change, write all related tests in a test file—even if not explicitly requested in the prompt.
- Write descriptive test method names using the pattern `testMethodName_Condition_ExpectedResult` or similar.
- Mock external dependencies in tests using `when(...).thenReturn(...)` or `doThrow(...)` for repository and service calls.
- Use `verify(...)` to assert interactions with mocks.
- Use constructor injection or `@InjectMocks` for services in tests.
- When adding or updating error handling in API controllers, always update or add tests to cover error scenarios and ensure error handling works as expected.
- Include mocks/stubs for third-party services.

## End-to-End Testing & Automation

- The Postman collection is automatically run using Newman in CI to ensure all endpoints work as expected.
- Test results are available in the CI pipeline output.

## Project Documentation & Artifacts

- Update the README.md file whenever necessary to reflect changes in features, endpoints, setup, usage, or documentation.
- Postman collection files are located in the `postman` folder. When adding or updating endpoints, ensure the Postman collection is updated accordingly.
- When API endpoints are added or changed, update the Mermaid diagram in `docs/[ProjectName]-diagram.md` to reflect the current API structure.
- When interface details or API contracts change, update the Interface Control Document (ICD) in the `docs` folder (e.g., `docs/icd.md`).
- The `docs` folder contains the Interface Control Document (ICD), API diagrams, and other technical documentation related to the project interfaces and architecture. Update these files as needed to keep documentation accurate and current.

## Workflow and Automation Instructions

- For commit messages, keep it extremely short but detailed with the file changes and the reason for the change. Don't use emojis.
- When asked to commit staged files, automatically generate a descriptive commit message summarizing the changes, and use it in the commit command.
    - If the user mentions "fix", "fixes", or "fixing", use a commit message starting with `fix:` followed by a summary of the fix.
    - If the user mentions "feature", "add", or "adding", use a commit message starting with `feat:` followed by a summary of the feature.
    - If the user mentions "refactor", use a commit message starting with `refactor:` followed by a summary of the refactor.
    - If the user mentions "docs" or documentation, use a commit message starting with `docs:` followed by a summary of the documentation change.
    - If the user mentions "test" or "tests", use a commit message starting with `test:` followed by a summary of the test change.
    - Otherwise, generate a clear and descriptive commit message based on the context.
- When asked to push, always check the current branch and push to that branch.
- When asked to create a branch, automatically generate a branch name based on the context of the request, using dashes to separate words (e.g., `feature-add-service-layer`).
    - If the user mentions "fix", "fixes", or "fixing", use a branch name starting with `fix-` followed by a context-based description (e.g., `fix-bug-in-controller`).
    - If the user mentions "feature", "add", or "adding", use a branch name starting with `feature-` followed by a context-based description (e.g., `feature-add-service-layer`).
    - If the user mentions "refactor", use a branch name starting with `refactor-` followed by a context-based description (e.g., `refactor-controller-logic`).
    - If the user mentions "docs" or documentation, use a branch name starting with `docs-` followed by a context-based description (e.g., `docs-update-readme`).
    - If the user mentions "test" or "tests", use a branch name starting with `test-` followed by a context-based description (e.g., `test-add-service-tests`).
    - Otherwise, generate a clear and descriptive branch name based on the context, using dashes to separate words.
- Always update the `.gitignore` file with any new files, folders, or patterns that should not be tracked by git as they are added to this repository.

## Monitoring & Observability

- When a new API endpoint is added or an existing endpoint is changed, create or update a corresponding Datadog monitor JSON file in the `/datadog` folder. Each monitor file should be named after the endpoint (e.g., `[ControllerName]-get-monitor.json`) and reflect the latest endpoint structure and behavior.
- Organize Datadog monitor files by creating a subfolder for each controller inside `/datadog` (e.g., `/datadog/[ControllerName]/`). Place each controller's monitors in its respective folder.

## README Maintenance & Quick Start

- Always keep the `README.md` up to date with:
  - A brief project description and its purpose.
  - Prerequisites and setup instructions.
  - How to run the application (including a sample `curl` command for a basic endpoint, e.g., `curl http://localhost:8080/[EndpointName]`).
  - How to run tests.
  - A pointer to the Postman collection (`postman/[ProjectName].postman_collection.json`) for comprehensive API testing.
  - References to API documentation (Swagger/OpenAPI UI), diagrams, and the Interface Control Document (ICD) in the `docs/` folder.
- Ensure new contributors can quickly get started by following the README instructions for setup, running, and testing the API.

## Postman Collection Guidelines

- When adding or updating endpoints, always ensure that all required variables (such as `baseUrl`) and any other necessary Postman-specific configuration are included in the Postman collection file (`postman/[ProjectName].postman_collection.json`).
- All API endpoints must have corresponding requests in the Postman collection with necessary variables and configurations included.
- When adding or updating a controller, always:
  - Add or update the corresponding Postman request.
  - Add or update test scripts in the request (e.g., check status code, response body).
  - Commit the updated collection.
- Define collection-level variables for any values referenced in requests (e.g., `baseUrl`, authentication tokens, etc.) so the collection works out-of-the-box when imported into Postman.
- Keep the Postman collection up to date with all endpoints, variables, and test scripts to ensure smooth API testing and automation.

## 📚 References
- https://google.github.io/styleguide/javaguide.html
- https://docs.spring.io/spring-boot/index.html
