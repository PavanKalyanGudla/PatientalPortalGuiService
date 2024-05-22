package com.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.constants.Constants;
import com.medical.dao.DoctorDao;
import com.medical.modal.Appointment;
import com.medical.modal.AppointmentTimeTable;
import com.medical.modal.Doctor;
import com.medical.modal.DoctorDailyAppointment;
import com.medical.modal.ResponseObj;

@Service
public class DoctorService {

	@Autowired
	DoctorDao doctorDao;
	
	public ResponseObj doctorLogin(String doctorId, String password) {
		ResponseObj responseObj = new ResponseObj();
		if(doctorDao.getDoctorCount(doctorId,password) > 0) {
			Doctor doctorObject = doctorDao.getDoctorObject(doctorId,password);
			if(null != doctorObject) {
				responseObj.setDoctor(doctorObject);
				responseObj.setResponseCode(Constants.SUCCESS_CODE);
				responseObj.setResponseMessage(Constants.SUCCESS_MSG);
			}else {
				responseObj.setDoctor(null);
				responseObj.setResponseCode(Constants.FAILURE_CODE);
				responseObj.setResponseMessage(Constants.UNAUTHORIZED_LOGIN);
			}
		}else {
			responseObj.setDoctor(null);
			responseObj.setResponseCode(Constants.FAILURE_CODE);
			responseObj.setResponseMessage(Constants.ACCOUNT_DOESNT_EXISTS);
		}
		return responseObj;
	}

	public String uploadDoctorImage(String doctorId, String password, byte[] bytes) {
		if(doctorDao.getDoctorCount(doctorId,password) > 0) {
			int count = doctorDao.updateDoctorProfilePic(doctorId, password, bytes);
			if(count > 0) {
				return Constants.UPLOAD_SUCCESS;
			}else {
				return Constants.UPLOAD_FAILED;
			}
		}else {
			return Constants.ACCOUNT_DOESNT_EXISTS;
		}
	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> allDoctors = doctorDao.getAllDoctors();
		return allDoctors;
	}

	public String saveDoctor(Doctor doctor) {
		boolean updateDoctor = doctorDao.updateDoctor(doctor);
		if(updateDoctor) {
			return Constants.DOCTOR_UPDATE_SUCCESS;
		}else {
			return Constants.DOCTOR_UPDATE_FAIL;
		}
	}
	
	public List<AppointmentTimeTable> getAppointmentTimeTable(String doctorId){
		return doctorDao.getAppointmentTimeTable(doctorId);
	}
	
	public String bookAppointment(AppointmentTimeTable a) {
		boolean bookAppointment = doctorDao.bookAppointment(a);
		if(bookAppointment) {
			return Constants.APPOINTMENT_SUCCESS;
		}else {
			return Constants.APPOINTMENT_FAIL;
		}
	}
	
	public DoctorDailyAppointment getAppointmentTimeTable_Todays(String doctorId) {
		return doctorDao.getAppointmentTimeTable_Todays(doctorId);
	}
	
	public String resetPassword(Doctor doctor) {
		int resetPassword = doctorDao.resetPassword(doctor);
		if(resetPassword > 0) {
			return Constants.PASSWORD_CHANGED_SUCCESS;
		}else {
			return Constants.PASSWORD_CHANGED_FAIL;
		}
	}
	
	public String closeAppointment(Appointment appointment) {
		int update = doctorDao.closeAppointment(appointment);
		if(update > 0) {
			return Constants.APPOINTMENT_CLOSE_SUCCESS;
		}else {
			return Constants.APPOINTMENT_CLOSE_FAIL;
		}
	}
	
	
}
