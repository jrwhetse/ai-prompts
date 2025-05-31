# Appointments API Diagram (Mermaid)

```mermaid
graph TD
    A[Client] -->|GET /appointments| B[AppointmentController]
    B --> C[AppointmentService]
    C --> D[AppointmentDto]
```
