package com.example.appointments.service;

import com.example.appointments.dto.AppointmentDto;
import java.util.List;

/**
 * Service interface for appointment operations.
 */
public interface AppointmentService {
    /**
     * Get all appointments.
     * @return list of appointments
     */
    List<AppointmentDto> getAllAppointments();
}
