package com.example.appointments.service;

import com.example.appointments.dto.AppointmentDto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppointmentServiceImplTest {
    private final AppointmentServiceImpl service = new AppointmentServiceImpl();

    @Test
    void getAllAppointments_ReturnsList() {
        List<AppointmentDto> result = service.getAllAppointments();
        assertNotNull(result);
    }
}
