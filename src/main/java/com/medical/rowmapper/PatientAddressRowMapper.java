package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.PatientAddressInfo;

public class PatientAddressRowMapper implements RowMapper<PatientAddressInfo>{

	@Override
	public PatientAddressInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		PatientAddressInfo address = new PatientAddressInfo();
		address.setAddressId(rs.getString("addressId"));
		address.setPatientId(rs.getString("patientId"));
		address.setMobile(rs.getString("mobile"));
		address.setEmail(rs.getString("email"));
		address.setStreet(rs.getString("street"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setZipCode(rs.getString("zipCode"));
		address.setDrNo(rs.getString("drNo"));;
		address.setEmergencyContactName(rs.getString("emergencyContactName"));
		address.setRelationShip(rs.getString("relationShip"));
		address.setEmergencyContactMobile(rs.getString("emergencyContactMobile"));
		address.setPassword(rs.getString("password"));
		return address;
	}

}
