package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.user.app.model.Patient;

public interface PatientService {
    
    Patient addPatient(Patient patient);

    List<Patient> getUsers();

    Optional<Patient> getPatientById(String id);

    Patient updatePatient(Patient patient);

    void deletePatientById(String id);
}
