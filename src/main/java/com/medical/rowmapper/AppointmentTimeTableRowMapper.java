package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.AppointmentTimeTable;

public class AppointmentTimeTableRowMapper implements RowMapper<AppointmentTimeTable>{

	@Override
	public AppointmentTimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {
		AppointmentTimeTable at = new AppointmentTimeTable();
		at.setDate(rs.getDate("date")+"");
		at.setDoctor_id(rs.getString("doctor_id"));
		at.setSlot1(rs.getString("slot1"));
		at.setSlot2(rs.getString("slot2"));
		at.setSlot3(rs.getString("slot3"));
		at.setSlot4(rs.getString("slot4"));
		at.setSlot5(rs.getString("slot5"));
		at.setSlot6(rs.getString("slot6"));
		at.setSlot7(rs.getString("slot7"));
		at.setSlot8(rs.getString("slot8"));
		at.setSlot9(rs.getString("slot9"));
		at.setSlot10(rs.getString("slot10"));
		at.setSlot11(rs.getString("slot11"));
		at.setSlot12(rs.getString("slot12"));
		return at;
	}

}
