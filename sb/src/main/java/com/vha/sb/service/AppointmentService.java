package com.vha.sb.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Appointment;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Location;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.vha.sb.dto.AppointmentDTO;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private static final String FHIR_SERVER_BASE = "https://hapi.fhir.org/baseR4";
    private final FhirContext ctx = FhirContext.forR4();
    private final IGenericClient client = ctx.newRestfulGenericClient(FHIR_SERVER_BASE);

    @Cacheable("appointments")
    public List<AppointmentDTO> getLast10Appointments(String patientId) {
        List<AppointmentDTO> result = new ArrayList<>();
        Bundle bundle = client.search()
                .forResource(Appointment.class)
                .where(Appointment.PATIENT.hasId(patientId))
                .sort().descending(Appointment.DATE)
                .count(10)
                .returnBundle(Bundle.class)
                .execute();
        for (Bundle.BundleEntryComponent entry : bundle.getEntry()) {
            Appointment appt = (Appointment) entry.getResource();
            String date = appt.getStartElement().getValueAsString();
            String practitioner = "Unknown";
            String location = "Unknown";
            for (Appointment.AppointmentParticipantComponent participant : appt.getParticipant()) {
                Reference actor = participant.getActor();
                if (actor != null && actor.getReferenceElement().getResourceType().equals("Practitioner")) {
                    Practitioner prac = client.read().resource(Practitioner.class)
                            .withId(actor.getReferenceElement().getIdPart())
                            .execute();
                    practitioner = prac.getNameFirstRep().getNameAsSingleString();
                }
                if (actor != null && actor.getReferenceElement().getResourceType().equals("Location")) {
                    Location loc = client.read().resource(Location.class)
                            .withId(actor.getReferenceElement().getIdPart())
                            .execute();
                    location = loc.getName();
                }
            }
            result.add(new AppointmentDTO(date, practitioner, location));
        }
        return result;
    }
}
