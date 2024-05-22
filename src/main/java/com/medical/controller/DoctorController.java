package com.medical.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medical.constants.Constants;
import com.medical.modal.Appointment;
import com.medical.modal.AppointmentTimeTable;
import com.medical.modal.Doctor;
import com.medical.modal.DoctorDailyAppointment;
import com.medical.modal.ResponseObj;
import com.medical.service.DoctorService;

@RestController
@CrossOrigin("http://localhost:4200")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
//	http://localhost:8080/doctorLogin?doctorId=john.doe&password=1234
	@GetMapping("/doctorLogin")
	public ResponseObj doctorLogin(String doctorId,String password) {
		return doctorService.doctorLogin(doctorId,password);
	}
	
//	/uploadDoctorProfile?doctorId="+doctorId+"&password="+password
	@PostMapping("/uploadDoctorProfile")
    public String uploadDoctorProfile(String doctorId, String password,@RequestParam("file") MultipartFile file) {
		try {
			return doctorService.uploadDoctorImage(doctorId, password, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Constants.APPLICATION_ERROR;
	}
	
	@PostMapping("/updateDoctorProfile")
	public String updateDoctorProfile(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	@GetMapping("/getDoctorProfilePic")
	public ResponseEntity<byte[]> getDoctorProfilePic(String doctorId, String password) {
		ResponseObj doctor = doctorLogin(doctorId,password);
		if(doctor.getResponseMessage().equals(Constants.SUCCESS_MSG)) {
			byte[] profilePic = doctor.getDoctor().getProfilePic();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<>(profilePic, headers, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors(){
		List<Doctor> allDoctors = doctorService.getAllDoctors();
		return allDoctors;
	}
	
	@GetMapping("/getAppointmentTimeTable")
	public List<AppointmentTimeTable> getAppointmentTimeTable(String doctorId){
		return doctorService.getAppointmentTimeTable(doctorId);
	}
	
	@PostMapping("/bookAppointment")
	public String bookAppointment(@RequestBody AppointmentTimeTable appointment) {
		return doctorService.bookAppointment(appointment);
	}
	
	@GetMapping("/getTodaysAllAppointment")
	public DoctorDailyAppointment getAppointmentTimeTable_Todays(String doctorId){
		return doctorService.getAppointmentTimeTable_Todays(doctorId);
	}
	
	@PostMapping("/updateDoctorPassword")
	public String updatePassword(@RequestBody Doctor doctor) {
		return doctorService.resetPassword(doctor);
	}
	
	@PostMapping("/UpdateCloseAppointment")
	public String closeAppointment(@RequestBody Appointment appointment) {
		return doctorService.closeAppointment(appointment);
	}

}
