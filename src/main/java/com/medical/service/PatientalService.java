package com.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.medical.dao.PatientalDao;
import com.medical.modal.Appointment;
import com.medical.modal.Cart;
import com.medical.modal.CartOrders;
import com.medical.modal.Patient;
import com.medical.modal.PatientAddressInfo;
import com.medical.modal.ResponseObj;
import com.medical.constants.Constants;

@Service
public class PatientalService {
	
	@Autowired
	PatientalDao dao;
	
//	public ResponseObj getUserDao(String userId, String password){
//		Patient patient = dao.getUser(userId, password);
//		ResponseObj response = new ResponseObj();
//		response.setPatient(patient);
//		if(null != patient) {
//			response.setResponseCode(Constants.SUCCESS_CODE);
//			response.setResponseMessage(Constants.SUCCESS_MSG);
//		}else {
//			response.setResponseCode(Constants.FAILURE_CODE);
//			response.setResponseMessage(Constants.FAILURE_MSG);
//		}
//		return response;
//	}
	
	public ResponseObj patientLogin(String patientId, String password) {
		ResponseObj responseObj = new ResponseObj();
		if(dao.getPatientCount(patientId) > 0) {
			Patient patientObject = dao.getPatientObject(patientId,password);
			responseObj.setPatient(patientObject);
			if( null != patientObject) {
				if(patientId.equals(patientObject.getPatientId())
						&& password.equals(patientObject.getAddress().getPassword())) {
					responseObj.setResponseCode(Constants.SUCCESS_CODE);
					responseObj.setResponseMessage(Constants.SUCCESS_MSG);
				}else {
					responseObj.setPatient(null);
					responseObj.setResponseCode(Constants.FAILURE_CODE);
					responseObj.setResponseMessage(Constants.UNAUTHORIZED_LOGIN);
				}
			}else {
				responseObj.setPatient(null);
				responseObj.setResponseCode(Constants.FAILURE_CODE);
				responseObj.setResponseMessage(Constants.UNAUTHORIZED_LOGIN);
			}
		}else {
			responseObj.setPatient(null);
			responseObj.setResponseCode(Constants.FAILURE_CODE);
			responseObj.setResponseMessage(Constants.ACCOUNT_DOESNT_EXISTS);
		}
		return responseObj;
	}
	
	public String addPatientRegistration(Patient patient) {
		return dao.addPatientRegistration(patient);
	}
	
	public String savePatient(Patient patient){
		return dao.savePatient(patient);
	}
	
	public String uploadImage(String patientId, String password, byte[] image) {
		if(dao.getPatientCount(patientId) > 0) {
			int count = dao.updateProfilePic(patientId, password, image);
			if(count > 0) {
				return Constants.UPLOAD_SUCCESS;
			}else {
				return Constants.UPLOAD_FAILED;
			}
		}else {
			return Constants.ACCOUNT_DOESNT_EXISTS;
		}
	}
	
	public List<Appointment> getPatientsActiveAppointments(String patientId){
		 return dao.getPatientsActiveAppointments(patientId);
	}
	
	public List<Appointment> getPatientPreviousAppointments(String patientId){
		 return dao.getPatientPreviousAppointments(patientId);
	}
	
	public List<Patient> getAllPatients(){
		List<Patient> allPatients = dao.getAllPatients();
		for(Patient p : allPatients) {
			p.setAddress(dao.getPatientAddressObject(p.getPatientId()));
			p.setInsuranceInfo(dao.getPatientInsuranceObject(p.getPatientId()));
		}
		return allPatients;
	}
	
	public List<PatientAddressInfo> getAllPatientsAddress(){
		return dao.getAllPatientsAddress();
	}
	
	public Cart getCart(String patientId) {
		Cart cart = dao.getCart(patientId);
		return cart;
	}
	
	public String addToCart(Cart c) {
		boolean addToCart = dao.addToCart(c);
		if(addToCart) {
			return Constants.ADDED_TO_CART;
		}
		return "";
	}
	
	public String placeOrder(CartOrders order) {
		return dao.placeOrder(order);
	}
	
	public List<CartOrders> getOrdersOfPatient(String patientId) {
		return dao.getOrdersOfPatient(patientId);
	}

}
