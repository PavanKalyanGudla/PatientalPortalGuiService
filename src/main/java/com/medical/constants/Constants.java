package com.medical.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	public static final String SUCCESS_CODE = "200";
	public static final String SUCCESS_MSG = "SUCCESS";
	public static final String FAILURE_CODE = "401";
	public static final String FAILURE_MSG = "FAIL";
	public static final String UNAUTHORIZED_LOGIN = "PASSWORD INCORRECT !!";
	public static final String APPLICATION_ERROR = "APPLICATION_EXCEPTION";
	public static final String ACCOUNT_DOESNT_EXISTS = "NOT FOUND, PLEASE DO REGISTER AND SIGNIN";
	public static final String UPLOAD_SUCCESS = "PROFILE PICTURE UPLOADED SUCCESS!.";
	public static final String UPDATE_SUCCESS = "PATIENT INFORMATION UPDATED SUCCESS!.";
	public static final String UPLOAD_FAILED = "PROFILE PICTURE UPLOADED FAILED!.";
	public static final String DOCTOR_UPDATE_SUCCESS = "INFORMATION UPDATED SUCCESS!.";
	public static final String DOCTOR_UPDATE_FAIL = "INFORMATION UPDATED FAIL!.";
	public static final String APPOINTMENT_SUCCESS = "APPOINTMENT SCHEDULED SUCCESS!.";
	public static final String APPOINTMENT_FAIL = "APPOINTMENT SCHEDULED FAILED!.";
	public static final String APPOINTMENT_CLOSE_SUCCESS = "APPOINTMENT CLOSED SUCCESS";
	public static final String APPOINTMENT_CLOSE_FAIL = "APPOINTMENT CLOSE FAILED";
	public static final String PASSWORD_CHANGED_SUCCESS = "PASSWORD CHANGED SUCCESS!";
	public static final String PASSWORD_CHANGED_FAIL = "PASSWORD CHANGED FAIL!";
	public static final String ADDED_TO_CART = "ADDED TO CART";
	public static final String ORDER_PLACED = "ORDER PLACED SUCCESSFULLY! ITEMS REMOVED FROM CART";
	public static final String ORDER_NOT_PLACED = "FAILED PLACING ORDER!";
	
	public static final Map<String,String> timeSlots = new HashMap<String,String>(){{
		put("slot1","9:00AM-9:30AM");
		put("slot2","9:30AM-10:00AM");
		put("slot3","10:00AM-10:30AM");
		put("slot4","10:30AM-11:00AM");
		put("slot5","11:00AM-11:30AM");
		put("slot6","11:30AM-12:00AM");
		put("slot7","1:00PM-1:30PM");
		put("slot8","1:30PM-2:00PM");
		put("slot9","2:00PM-2:30PM");
		put("slot10","2:30PM-3:00PM");
		put("slot11","3:00PM-3:30PM");
		put("slot12","3:30PM-4:00PM");
	}};
	
	public static final String GET_PATIENT_COUNT = "select count(*) from Patient where patientId=?";
	
	public static final String GET_PATIENT_INFO = "select * from Patient where patientId=?";
	
	public static final String GET_PATIENT_ADDRESS_INFO = "select * from PatientAddress where addressId=?";
	
	public static final String GET_PATIENT_INSURANCE_INFO = "select * from InsuranceInfo where insuranceInfoId=?";
	
	public static final String GET_DOCTOR_COUNT = "select count(*) from Doctor where doctor_id=? and password=?";
	
	public static final String GET_DOCTOR_INFO = "select * from Doctor where doctor_id=? and password=?";
	
	public static final String GET_ALL_DOCTORS = "select * from Doctor";
	
	public static final String GET_ALL_PATIENTS = "select * from Patient";
	
	public static final String GET_ALL_PATIENTS_ADDRESS = "select * from PatientAddress";
	
	public static final String GET_PATIENT_CART = "select * from cart where patientId = ?";
	
	public static final String GET_DOCTORS_ACTIVE_APPOINTMENTS = "select * from appointmentTimeTable where doctor_id = ? and date = CURRENT_DATE;";
	
	public static final String GET_DOCTORS_APPOINTMENTS = "select * from Appointments where AppointmentDate = current_date and doctor_id = ?";
	
	public static final String GET_APPOINTMENT_TIMETABLE = "select * from appointmentTimeTable where doctor_id = ? and date >= CURRENT_DATE";
	
	public static final String GET_PATIENT_UPCOMING_APPOINTMENTS = "select * from Appointments where patientId=? and STR_TO_DATE(AppointmentDate, '%Y-%m-%d') >= CURDATE()";

	public static final String GET_PATIENT_PREVIOUS_APPOINTMENTS = "select * from Appointments where patientId=? and STR_TO_DATE(AppointmentDate, '%Y-%m-%d') <= CURDATE()";
	
	public static final String GET_PATIENT_ORDERS = "select * from cartorders where patientId = ?";
	
	public static final String INSERT_PATIENT = "insert into Patient(patientId,firstName,lastName,age,dob,maritialStatus,profilePic,gender,addressId,insuranceInfoId)"
			+ "values(?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_ADDRESS = "insert into PatientAddress(addressId,patientId,mobile,email,street,city,state,drNo,zipCode,emergencyContactName,relationShip,emergencyContactMobile,password)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_INSURANCE = "insert into InsuranceInfo(insuranceInfoId,patientId,providerName,policyNumber,groupNumber,coverageType,effectiveDate,expirationDate)"
			+ "values(?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_ORDER = "insert into cartorders(patientId,total_amount,order_status,created_at,products) values(?,?,?,?,?)";

	public static final String ADD_TO_CART = "INSERT INTO cart (patientId, products, added_at) VALUES (?, ?, ?)";
	
	public static final String UPDATE_ADD_TO_CART = "UPDATE cart SET products = ?, added_at = ? WHERE patientId = ?";
	
	public static final String UPLOAD_PROFILE_PIC = "update Patient set profilePic = ? where patientId = ?";
	
	public static final String UPDATE_PATIENT_INFO = "update Patient set firstName=?,lastName=?,age=?,dob=?,maritialStatus=?,profilePic=?,gender=? where patientId=?";
	
	public static final String UPDATE_ADDRESS_INFO = "update PatientAddress set mobile=?,email=?,street=?,city=?,state=?,zipCode=?,emergencyContactName=?,relationShip=?,emergencyContactMobile=?,password=? where addressId=?";
	
	public static final String UPDATE_INSURANCE_INFO = "update InsuranceInfo set providerName=?,policyNumber=?,groupNumber=?,coverageType=?,effectiveDate=?,expirationDate=? where insuranceInfoId=?";
	
	public static final String UPLOAD_DOCTOR_PROFILE_PIC = "update Doctor set profilePic = ? where doctor_id = ? and password = ?";
	
	public static final String UPDATE_DOCTOR_PASSWORD = "update Doctor set password = ? where doctor_id = ?";
	
	public static final String UPLOAD_DOCTOR_PROFILE = "update Doctor set first_name=?,last_name=?,specialization=?,phone_number=?,address=?,city=?,state=?,country=?,postal_code=?,bio=?,date_of_birth=?,gender=? where doctor_id = ? and password = ?";
	
	public static final String UPDATE_APPOINTMENT = "update Appointments set Status = ? , HealthStatus = ? , TestsToBeChecked = ? , Medication = ? where AppointmentID = ?";
	
	public static final String BOOK_APPOINTMENT_TIMETABLE = "update appointmentTimeTable set slot1=?,slot2=?,slot3=?,slot4=?,slot5=?,slot6=?,slot7=?,slot8=?,slot9=?,slot10=?,slot11=?,slot12=? where date=? and doctor_id=?";
	
	public static final String BOOK_DOCTOR_APPOINTMENT = "insert into Appointments(patientId,doctor_id,AppointmentDate,StartTime,EndTime,AppointmentType,Status,CreatedOn,UpdatedOn,Notes,appointmentSlot)"
			+"values(?,?,?,?,?,?,?,NOW(),NOW(),?,?)";
	
//	public static String getEmailAppointmentContent(String fullName, String date, String time, String location) {
//		String EMAIL_APPOINTMENT_CONTENT = String.format(
//			    "Dear %s,%n%n" +
//			    "We are pleased to inform you that your appointment has been successfully scheduled. Please find the details of your appointment below:%n%n" +
//			    "- **Appointment Date:** %s %n" +
//			    "- **Appointment Time:** %s %n" +
//			    "- **Location:** %s %n" +
//			    "Additional Information:%n" +
//			    "Please make sure all the mandatory documents %n%n" +
//			    "If you have any questions or need to make changes to your appointment, please do not hesitate to contact us. We are here to assist you.%n%n" +
//			    "Thank you for choosing our services, and we look forward to serving you on the scheduled date.%n%n" +
//			    "Best regards,%n" +
//			    "Online Banking System%n" +
//			    "Street, Beaumont , Texas.%n" +
//			    "+1 9999999999%n" +
//			    "onlinebanking@example.com", fullName, date, time ,location
//			);
//		return EMAIL_APPOINTMENT_CONTENT;
//	}
//	
//
//	public static String forgotEmailUsernameRemember(Patient user) {
//		String EMAIL_FORGOT_PASSWORD = String.format(
//				"Dear %s,%n%n" +
//				"We have received your request to reset your password for UserId : %s.%n" +
//				"We're happy to assist you with this. Your password is as follows:%n%n" +
//				"Password: %s%n%n"+
//				"Thank you for using Online Banking. We are committed to ensuring the safety and security of your account.%n%n"+
//				"Sincerely,%n"+
//				"Online Banking System%n" +
//			    "Street, Beaumont , Texas.%n" +
//			    "+1 9999999999%n" +
//			    "onlinebanking@example.com",
//			    user.getFirstName()+" "+user.getLastName(),
//			    user.getUserId(),
//			    user.getPassword()
//			);
//		return EMAIL_FORGOT_PASSWORD;
//	}
	
}
