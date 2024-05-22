package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.medical.modal.Patient;

public class PatientRowMapper implements RowMapper<Patient>{

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient patient = new Patient();
		patient.setPatientId(rs.getString("patientId"));
		patient.setFirstName(rs.getString("firstName"));
		patient.setLastName(rs.getString("lastName"));
		patient.setAge(rs.getString("age"));
		patient.setDob(rs.getString("dob"));
		patient.setMaritialStatus(rs.getString("maritialStatus"));
		patient.setProfilePic(rs.getBytes("profilePic"));
		patient.setGender(rs.getString("gender"));
		return patient;
	}

}
