package org.user.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="appointments")
public class AppointmentSlots {
	@Id
	private String id;
	private String doctornamee;
	private String specialization;
	private LocalDate date;
	private LocalTime time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDoctornamee() {
		return doctornamee;
	}
	public void setDoctornamee(String doctornamee) {
		this.doctornamee = doctornamee;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	

}
