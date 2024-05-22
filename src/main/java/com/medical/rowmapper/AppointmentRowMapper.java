package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.Appointment;

public class AppointmentRowMapper implements RowMapper<Appointment>{

	@Override
	public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Appointment op = new Appointment();
		op.setAppointmentID(rs.getInt("AppointmentID")+"");
		op.setPatientId(rs.getString("patientId"));
		op.setDoctor_id(rs.getString("doctor_id"));
		op.setAppointmentDate(rs.getString("AppointmentDate"));
		op.setStartTime(rs.getString("StartTime")+"");
		op.setEndTime(rs.getString("EndTime")+"");
		op.setAppointmentType(rs.getString("AppointmentType"));
		op.setStatus(rs.getString("Status"));
		op.setCreatedOn(rs.getString("CreatedOn"));
		op.setUpdatedOn(rs.getString("UpdatedOn"));
		op.setNotes(rs.getString("Notes"));
		op.setAppointmentSlot(rs.getString("appointmentSlot"));
		op.setHealthStatus(rs.getString("HealthStatus"));
		op.setTestsToBeChecked(rs.getString("TestsToBeChecked"));
		op.setMedication(rs.getString("Medication"));
		return op;
	}

}
