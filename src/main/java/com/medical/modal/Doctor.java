package com.medical.modal;

import java.util.Arrays;

public class Doctor {
	private String doctor_id;
	private String first_name;
	private String last_name;
	private String specialization;
	private String email;
	private String phone_number;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postal_code;
	private String bio;
	private byte[] profilePic;
	private String date_of_birth;
	private String gender;
	private String date_added;
	private String date_updated;
	private String password;
	private String newpassword;
	
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public byte[] getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate_added() {
		return date_added;
	}
	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
	public String getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", specialization=" + specialization + ", email=" + email + ", phone_number=" + phone_number
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", postal_code=" + postal_code + ", bio=" + bio + ", profilePic=" + Arrays.toString(profilePic)
				+ ", date_of_birth=" + date_of_birth + ", gender=" + gender + ", date_added=" + date_added
				+ ", date_updated=" + date_updated + ", password=" + password + ", newpassword=" + newpassword + "]";
	}
	
}
