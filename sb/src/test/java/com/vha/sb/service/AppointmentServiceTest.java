package com.vha.sb.service;

import com.vha.sb.dto.AppointmentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = Mockito.spy(new AppointmentService());
    }

    @Test
    void testGetLast10Appointments_Performance() {
        long start = System.currentTimeMillis();
        List<AppointmentDTO> result = appointmentService.getLast10Appointments("example-patient-id");
        long duration = System.currentTimeMillis() - start;
        assertTrue(duration < 2000, "Should respond within 2 seconds");
        assertNotNull(result);
    }

    @Test
    void testGetLast10Appointments_CacheReliability() {
        List<AppointmentDTO> first = appointmentService.getLast10Appointments("example-patient-id");
        List<AppointmentDTO> second = appointmentService.getLast10Appointments("example-patient-id");
        assertEquals(first, second);
    }
}
