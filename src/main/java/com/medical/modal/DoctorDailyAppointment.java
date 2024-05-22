package com.medical.modal;

import java.util.List;
import java.util.Map;

public class DoctorDailyAppointment {
	private AppointmentTimeTable timeTable;
	private Map<String,Patient> patients;
	private List<Appointment> appointments;
	
	public AppointmentTimeTable getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(AppointmentTimeTable timeTable) {
		this.timeTable = timeTable;
	}
	public Map<String, Patient> getPatients() {
		return patients;
	}
	public void setPatients(Map<String, Patient> patients) {
		this.patients = patients;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
}
