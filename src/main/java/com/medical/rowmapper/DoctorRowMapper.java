package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.*;

public class DoctorRowMapper implements RowMapper<Doctor>{

	@Override
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctor doctor = new Doctor();
		doctor.setDoctor_id(rs.getString("doctor_id"));
		doctor.setFirst_name(rs.getString("first_name"));
		doctor.setLast_name(rs.getString("last_name"));
		doctor.setSpecialization(rs.getString("specialization"));
		doctor.setEmail(rs.getString("email"));
		doctor.setPhone_number(rs.getString("phone_number"));
		doctor.setAddress(rs.getString("address"));
		doctor.setCity(rs.getString("city"));
		doctor.setState(rs.getString("state"));
		doctor.setCountry(rs.getString("country"));
		doctor.setPostal_code(rs.getString("postal_code"));
		doctor.setBio(rs.getString("bio"));
		doctor.setProfilePic(rs.getBytes("profilePic"));
		doctor.setDate_of_birth(rs.getString("date_of_birth"));
		doctor.setGender(rs.getString("gender"));
		doctor.setDate_added(rs.getString("date_added"));
		doctor.setDate_updated(rs.getString("date_updated"));
		doctor.setPassword(rs.getString("password"));
		return doctor;
	}
}
