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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.medical.constants.Constants;
import com.medical.modal.Appointment;
import com.medical.modal.Cart;
import com.medical.modal.CartOrders;
import com.medical.modal.Patient;
import com.medical.modal.PatientAddressInfo;
import com.medical.modal.ResponseObj;
import com.medical.service.PatientalService;

@RestController
@CrossOrigin("http://localhost:4200")
public class PatientalController {
	
	@Autowired
	PatientalService service;
	
	@GetMapping("/health")
	public String patientalPortalHealthCheck() {
		return "PatientalHealthy";
	}
	
//	@GetMapping("/login")
//	public ResponseObj login(String userId, String password) {
//		ResponseObj response = service.getUserDao(userId,password);
//		return response;
//	}
	
//	http://localhost:8080/patientLogin?patientId=pavangudla4&password=1234
	@GetMapping("/patientLogin")
	public ResponseObj patientLogin(String patientId,String password) {
		ResponseObj patient = service.patientLogin(patientId,password);
		return patient;
	}
	
//	http://localhost:8080/getProfilePic?patientId=pavangudla4&password=1234
	@GetMapping("/getProfilePic")
	public ResponseEntity<byte[]> getPatientImage(String patientId, String password){
		ResponseObj patient = service.patientLogin(patientId, password);
		if(patient.getResponseMessage().equals(Constants.SUCCESS_MSG)) {
			byte[] profilePic = patient.getPatient().getProfilePic();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<>(profilePic, headers, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addPatient")
	public String addPatientRegistration(@RequestBody Patient patient) {
		return service.addPatientRegistration(patient);
	}
	
	@PostMapping("/uploadPatientProfile")
    public String uploadImage(String patientId, String password,@RequestParam("file") MultipartFile file) {
		try {
			return service.uploadImage(patientId, password, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Constants.APPLICATION_ERROR;
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@RequestBody Patient patient) {
		return service.savePatient(patient);
	}
	
//	http://localhost:8080/getPatientsActiveAppointments?patientId=pavangudla4
	@GetMapping("/getPatientsActiveAppointments")
	public List<Appointment> getPatientsActiveAppointments(String patientId) {
		return service.getPatientsActiveAppointments(patientId);
	}
	
//	http://localhost:8080/getPatientPreviousAppointments?patientId=pavangudla4
	@GetMapping("/getPatientPreviousAppointments")
	public List<Appointment> getPatientPreviousAppointments(String patientId){
		return service.getPatientPreviousAppointments(patientId);
	}
	
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients(){
		return service.getAllPatients();
	}
	
	@GetMapping("/getAllPatientAddress")
	public List<PatientAddressInfo> getAllPatientsAddress(){
		return service.getAllPatientsAddress();
	}
	
	@GetMapping("/getPatientCart")
	public Cart getCart(String patientId) {
		return service.getCart(patientId);
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody Cart c) {
		return service.addToCart(c);
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody CartOrders order) {
		return service.placeOrder(order);
	}
	
	@GetMapping("/getOrders")
	public List<CartOrders> getOrdersList(String patientId) {
		return service.getOrdersOfPatient(patientId);
	}
	
}
