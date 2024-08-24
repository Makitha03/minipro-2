package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.app.model.Medication;
import org.user.app.repository.MedicationRepository;

@Service
public class MedicationImplementation implements  MedicationService {

	
	@Autowired
	private  MedicationRepository medicationRepository ;
	@Override
	public Medication addMedication(Medication medication) {
	
		return this.medicationRepository.save(medication);
	}

	@Override
	public List<Medication> getUsers() {
		
		return this.medicationRepository.findAll();
		}

	@Override
	public Optional<Medication> getMedicationById(String id) {
		
		return this.medicationRepository.findById(id);
	}

	@Override
	public Medication updateMedication(Medication medication) {
		
		return this.medicationRepository.save(medication);
		}

	@Override
	public void deleteMedicationById(String id) {
		this.medicationRepository.deleteById(id);
		
	}

}
