package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.app.model.Doctor;

import org.user.app.repository.DoctorRepository;

@Service
public class DoctorImplementation implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

@Override    
public Doctor addDoctor(Doctor doctor) {
		
		return this.doctorRepository.save(doctor);
	}
    

    @Override
    public List<Doctor> getUsers() { 
    	// Corrected method name to match the purpose
        return this.doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepository.findById(id);
    }


	@Override
	public void deleteDoctorById(String id) {
		doctorRepository.deleteById(id);
		
	}

	
}
