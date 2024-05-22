package com.medical.modal;

public class Patient {
	private String patientId;
	private String firstName;
	private String lastName;
	private String dob;
	private String age;
	private String maritialStatus;
	private byte[] profilePic;
	private String gender;
	private PatientAddressInfo address;
	private PatientInsuranceInfo insuranceInfo;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMaritialStatus() {
		return maritialStatus;
	}
	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}
	public byte[] getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public PatientAddressInfo getAddress() {
		return address;
	}
	public void setAddress(PatientAddressInfo address) {
		this.address = address;
	}
	public PatientInsuranceInfo getInsuranceInfo() {
		return insuranceInfo;
	}
	public void setInsuranceInfo(PatientInsuranceInfo insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}
	
}
