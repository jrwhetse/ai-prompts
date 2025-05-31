package com.example.appointments.controller;

import com.example.appointments.dto.AppointmentDto;
import com.example.appointments.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAppointments_ReturnsListOfAppointments() {
        List<AppointmentDto> mockList = Arrays.asList(
                new AppointmentDto(1L, "Test Appointment", "2025-05-31T10:00:00")
        );
        when(appointmentService.getAllAppointments()).thenReturn(mockList);
        ResponseEntity<List<AppointmentDto>> response = appointmentController.getAllAppointments();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        AppointmentDto dto = response.getBody().get(0);
        assertEquals(1L, dto.getId());
        assertEquals("Test Appointment", dto.getTitle());
        assertEquals("2025-05-31T10:00:00", dto.getDateTime());
    }
}
