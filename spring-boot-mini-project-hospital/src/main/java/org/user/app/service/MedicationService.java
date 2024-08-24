package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.user.app.model.Medication;

public interface MedicationService {
	
	
	
	public Medication addMedication(Medication  medication);
	public List< Medication> getUsers();
	public Optional<Medication> getMedicationById(String id);
	public  Medication updateMedication( Medication  medication);
	public void deleteMedicationById(String id);
	

}
