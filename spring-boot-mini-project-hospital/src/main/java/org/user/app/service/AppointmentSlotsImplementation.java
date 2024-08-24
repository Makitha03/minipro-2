package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.app.model.AppointmentSlots;
import org.user.app.repository.AppointmentSlotsRepository;

@Service
public class AppointmentSlotsImplementation implements AppointmentSlotsService {
	
	@Autowired
	private AppointmentSlotsRepository appointmentSlotsRepository;

	@Override
	public AppointmentSlots addAppointmentSlots(AppointmentSlots appointmentSlots) {
		// TODO Auto-generated method stub
		return this.appointmentSlotsRepository.save(appointmentSlots);
	}

	@Override
	public List<AppointmentSlots> getUsers() {
		
		return this.appointmentSlotsRepository.findAll();
		}

	@Override
	public Optional<AppointmentSlots> getAppointmentSlotsById(String id) {
		
		return this.appointmentSlotsRepository.findById(id);
	}

	@Override
	public AppointmentSlots updateAppointmentSlots(AppointmentSlots appointmentSlots) {
		
		return this.appointmentSlotsRepository.save(appointmentSlots);
	}

	@Override
	public void deleteAppointmentSlotsById(String id) {
		this.appointmentSlotsRepository.deleteById(id);
		
	}

}
