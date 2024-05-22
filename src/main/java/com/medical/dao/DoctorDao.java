package com.medical.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.medical.constants.Constants;
import com.medical.modal.Appointment;
import com.medical.modal.AppointmentTimeTable;
import com.medical.modal.Doctor;
import com.medical.modal.DoctorDailyAppointment;
import com.medical.modal.Patient;
import com.medical.service.EmailService;
import com.medical.rowmapper.*;

@Component
public class DoctorDao {

	@Autowired
	EmailService emailService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public DoctorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getDoctorCount(String doctorId,String password) {
		int count = 0;
		try {
			count = jdbcTemplate.queryForObject(Constants.GET_DOCTOR_COUNT,Integer.class,doctorId,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Doctor getDoctorObject(String doctorId, String password) {
		Doctor doctorObj = null;
		if(getDoctorCount(doctorId,password) > 0) {
			try {
				doctorObj = jdbcTemplate.queryForObject(Constants.GET_DOCTOR_INFO, new Object[] {doctorId,password}, new DoctorRowMapper());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return doctorObj;
	}

	public int updateDoctorProfilePic(String doctorId, String password, byte[] image) {
		try {
			int update = jdbcTemplate.update(Constants.UPLOAD_DOCTOR_PROFILE_PIC,image,doctorId,password);
			return update;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctor = jdbcTemplate.query(Constants.GET_ALL_DOCTORS, new DoctorRowMapper());
		return doctor;
	}

	public boolean updateDoctor(Doctor doctor) {
		boolean flag = false;
		try {
			int update = jdbcTemplate.update(Constants.UPLOAD_DOCTOR_PROFILE, doctor.getFirst_name(),doctor.getLast_name(),doctor.getSpecialization(),
					doctor.getPhone_number(),doctor.getAddress(),doctor.getCity(),doctor.getState(),doctor.getCountry(),doctor.getPostal_code(),doctor.getBio(),
					doctor.getDate_of_birth(),doctor.getGender(),doctor.getDoctor_id(),doctor.getPassword());
			if(update > 0) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int resetPassword(Doctor doctor) {
		int result = 0;
		try {
			result = jdbcTemplate.update(Constants.UPDATE_DOCTOR_PASSWORD,doctor.getNewpassword(),doctor.getDoctor_id());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<AppointmentTimeTable> getAppointmentTimeTable(String doctorId) {
		List<AppointmentTimeTable> timeTable = null;
		try {
			timeTable = jdbcTemplate.query(Constants.GET_APPOINTMENT_TIMETABLE, new Object[] {doctorId}, new AppointmentTimeTableRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return timeTable;
	}
	
	public DoctorDailyAppointment getAppointmentTimeTable_Todays(String doctorId){
		DoctorDailyAppointment response = new DoctorDailyAppointment();
		AppointmentTimeTable timeTable = null;
		Patient patient = null;
		List<Appointment> appointment = null;
		try {
			timeTable = jdbcTemplate.queryForObject(Constants.GET_DOCTORS_ACTIVE_APPOINTMENTS, new Object[] {doctorId}, new AppointmentTimeTableRowMapper());
			appointment = jdbcTemplate.query(Constants.GET_DOCTORS_APPOINTMENTS, new Object[] {doctorId} , new AppointmentRowMapper());
			if(null != timeTable) {
				Map<String,Patient> data = new HashMap<>();
				for (int i = 1; i <= 12; i++) {
		            try {
		                String methodName = "getSlot" + i;
		                Method method = AppointmentTimeTable.class.getMethod(methodName);
		                Object result = method.invoke(timeTable);
		                if(null != result) {
		                	patient = jdbcTemplate.queryForObject(Constants.GET_PATIENT_INFO, new Object[] {result}, new PatientRowMapper());
		                	data.put("slot"+i, patient);
		                }
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
				response.setTimeTable(timeTable);
				response.setPatients(data);
				response.setAppointments(appointment);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public boolean bookAppointment(AppointmentTimeTable a) {
		int timeTable = 0;
		boolean response = false;
		String[] slotTime = Constants.timeSlots.get(a.getSelectedSlot()).split("-");
		int appointment = 0;
		try {
			if(null != a) {
				timeTable = jdbcTemplate.update(Constants.BOOK_APPOINTMENT_TIMETABLE,a.getSlot1(),a.getSlot2(),a.getSlot3(),a.getSlot4(),a.getSlot5(),
						a.getSlot6(),a.getSlot7(),a.getSlot8(),a.getSlot9(),a.getSlot10(),a.getSlot11(),a.getSlot12(),
						a.getDate(),a.getDoctor_id());
				appointment = jdbcTemplate.update(Constants.BOOK_DOCTOR_APPOINTMENT,a.getPatientInsert(),a.getDoctor_id(),a.getDate(),slotTime[0],
						slotTime[1],"","ACTIVE","",a.getSelectedSlot());
			}
			if(timeTable > 0 && appointment > 0) {
				response = true;
			}else {
				response = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public int closeAppointment(Appointment app) {
		int update = 0;
		try {
			update = jdbcTemplate.update(Constants.UPDATE_APPOINTMENT,app.getStatus(),app.getHealthStatus(),app.getTestsToBeChecked(),app.getMedication(),app.getAppointmentID());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return update;
	}

}
