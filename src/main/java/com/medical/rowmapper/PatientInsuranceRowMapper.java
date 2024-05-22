package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.PatientInsuranceInfo;

public class PatientInsuranceRowMapper implements RowMapper<PatientInsuranceInfo>{

	@Override
	public PatientInsuranceInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		PatientInsuranceInfo insurance = new PatientInsuranceInfo();
		insurance.setInsuranceInfoId(rs.getString("insuranceInfoId"));
		insurance.setPatientId(rs.getString("patientId"));
		insurance.setProviderName(rs.getString("providerName"));
		insurance.setPolicyNumber(rs.getString("policyNumber"));
		insurance.setGroupNumber(rs.getString("groupNumber"));
		insurance.setCoverageType(rs.getString("coverageType"));
		insurance.setEffectiveDate(rs.getString("effectiveDate"));
		insurance.setExpirationDate(rs.getString("expirationDate"));
		return insurance;
	}

}
