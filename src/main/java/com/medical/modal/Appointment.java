package com.medical.modal;

public class Appointment {
	private String AppointmentID;
	private String patientId;
	private String doctor_id;
	private String AppointmentDate;
	private String StartTime;
	private String EndTime;
	private String AppointmentType;
	private String Status;
	private String CreatedOn;
	private String UpdatedOn;
	private String Notes;
	private String appointmentSlot;
	private String healthStatus;
	private String testsToBeChecked;
	private String medication;
	
	public String getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		AppointmentID = appointmentID;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getAppointmentType() {
		return AppointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		AppointmentType = appointmentType;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}
	public String getUpdatedOn() {
		return UpdatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		UpdatedOn = updatedOn;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getAppointmentSlot() {
		return appointmentSlot;
	}
	public void setAppointmentSlot(String appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public String getTestsToBeChecked() {
		return testsToBeChecked;
	}
	public void setTestsToBeChecked(String testsToBeChecked) {
		this.testsToBeChecked = testsToBeChecked;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
}
