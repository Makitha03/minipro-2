package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.app.model.Patient;
import org.user.app.repository.PatientRepository;

@Service
public class PatientImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getUsers() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(String id) {
        patientRepository.deleteById(id);
    }
}
