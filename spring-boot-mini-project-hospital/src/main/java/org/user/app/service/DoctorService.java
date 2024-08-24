package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.user.app.model.Doctor;




public interface DoctorService {
	public Doctor addDoctor(Doctor doctor);
	public List<Doctor> getUsers();
    public Optional<Doctor> getDoctorById(String id);
	public void deleteDoctorById(String id);
    



}
