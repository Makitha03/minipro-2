package org.user.app.service;

import java.util.List;
import java.util.Optional;

import org.user.app.model.AppointmentSlots;

public interface AppointmentSlotsService {
	
	
	public AppointmentSlots addAppointmentSlots(AppointmentSlots appointmentSlots);
	public List<AppointmentSlots> getUsers();
	public Optional<AppointmentSlots> getAppointmentSlotsById(String id);
	public AppointmentSlots updateAppointmentSlots(AppointmentSlots appointmentSlots);
	public void deleteAppointmentSlotsById(String id);

}
