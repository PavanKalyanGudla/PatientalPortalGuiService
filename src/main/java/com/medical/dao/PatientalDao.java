package com.medical.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.medical.constants.Constants;
import com.medical.constants.EmailConstants;
import com.medical.modal.Appointment;
import com.medical.modal.Cart;
import com.medical.modal.CartOrders;
import com.medical.modal.Patient;
import com.medical.modal.PatientAddressInfo;
import com.medical.modal.PatientInsuranceInfo;
import com.medical.rowmapper.AppointmentRowMapper;
import com.medical.rowmapper.PatientAddressRowMapper;
import com.medical.rowmapper.PatientInsuranceRowMapper;
import com.medical.rowmapper.PatientRowMapper;
import com.medical.rowmapper.CartRowMapper;
import com.medical.rowmapper.CartOrdersMapper;
import com.medical.service.EmailService;

@Component
public class PatientalDao {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public PatientalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
//	public Patient getUser(String userId, String password) {
//		Patient patient = null;
//		try {
//			patient = jdbcTemplate.queryForObject(Constants.GET_USER_INFO, new Object[] {userId,password}, new PatientRowMapper());
////			byte[] encode = null;
////			if(user.getProfilePic() != null) {
////				encode = java.util.Base64.getEncoder().encode(user.getProfilePic());
////			}
//		}catch (EmptyResultDataAccessException e) {
////			e.printStackTrace();
//        }
//		return patient;
//	}
	
	public int getPatientCount(String patientId) {
		int count = 0;
		try {
			count = jdbcTemplate.queryForObject(Constants.GET_PATIENT_COUNT,Integer.class,patientId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Patient getPatientObject(String patientId, String password) {
		Patient patient = null;
		PatientAddressInfo address = null;
		PatientInsuranceInfo insurance = null;
		if(getPatientCount(patientId) > 0) {
			try {
				patient = jdbcTemplate.queryForObject(Constants.GET_PATIENT_INFO, new Object[] {patientId}, new PatientRowMapper());
				address = getPatientAddressObject(patientId);
				insurance = getPatientInsuranceObject(patientId);
				patient.setAddress(address);
				patient.setInsuranceInfo(insurance);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return patient;
	}
	
	public PatientAddressInfo getPatientAddressObject(String addressId) {
		PatientAddressInfo address = null;
		if(getPatientCount(addressId) > 0) {
			try {
				address = jdbcTemplate.queryForObject(Constants.GET_PATIENT_ADDRESS_INFO, new Object[] {addressId}, new PatientAddressRowMapper());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return address;
	}
	
	public PatientInsuranceInfo getPatientInsuranceObject(String insuranceInfoId) {
		PatientInsuranceInfo insuranceInfo = null;
		if(getPatientCount(insuranceInfoId) > 0) {
			try {
				insuranceInfo = jdbcTemplate.queryForObject(Constants.GET_PATIENT_INSURANCE_INFO, new Object[] {insuranceInfoId}, new PatientInsuranceRowMapper());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return insuranceInfo;
	}
	
	public int updateProfilePic(String patientId, String password, byte[] image){
		try {
			int update = jdbcTemplate.update(Constants.UPLOAD_PROFILE_PIC , image , patientId);
			return update;
		}catch(Exception e) {
			return 0;
		}
	}
	
	public String addPatientRegistration(Patient patient) {
		int insPatient = 0;
		int insAddress = 0;
		int insInsurance = 0;
		LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = today.format(formatter);
	    
	    if(getPatientCount(patient.getPatientId())>0) {
	    	return "Patient Already Exists";
	    }else {
	    	try {
				insPatient = jdbcTemplate.update(Constants.INSERT_PATIENT,patient.getPatientId(),patient.getFirstName(),patient.getLastName(),
						patient.getAge(),patient.getDob(),patient.getMaritialStatus(),patient.getProfilePic(),patient.getGender(),
						patient.getAddress().getAddressId(),patient.getInsuranceInfo().getInsuranceInfoId());
				if(insPatient > 0) {
					insAddress = jdbcTemplate.update(Constants.INSERT_ADDRESS,patient.getAddress().getAddressId(),patient.getAddress().getPatientId(),
							patient.getAddress().getMobile(),patient.getAddress().getEmail(),patient.getAddress().getStreet(),
							patient.getAddress().getCity(),patient.getAddress().getState(),patient.getAddress().getDrNo(),patient.getAddress().getZipCode(),
							patient.getAddress().getEmergencyContactName(),patient.getAddress().getRelationShip(),
							patient.getAddress().getEmergencyContactMobile(),patient.getAddress().getPassword());
					if(insAddress > 0) {
						insInsurance = jdbcTemplate.update(Constants.INSERT_INSURANCE,patient.getInsuranceInfo().getInsuranceInfoId(),
								patient.getInsuranceInfo().getPatientId(),patient.getInsuranceInfo().getProviderName(),
								patient.getInsuranceInfo().getPolicyNumber(),patient.getInsuranceInfo().getGroupNumber(),
								patient.getInsuranceInfo().getCoverageType(),patient.getInsuranceInfo().getEffectiveDate(),
								patient.getInsuranceInfo().getExpirationDate());
						if(insInsurance > 0) {
							String body = EmailConstants.getPatientRegistrationBody(patient.getFirstName(), patient.getPatientId(), patient.getAddress().getEmail(), formattedDate);
							emailService.sendSimpleEmail(patient.getAddress().getEmail(), EmailConstants.EMAIL_Registration_SUCCESSFUL, body);
							return "Patient Created Successfully ! ";
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
		return "";
	}
	
	public String savePatient(Patient patient){
		int updatePatient = 0;
		int updateAddress = 0;
		int updateInsurance = 0;
		if(null != patient) {
			try {
				updatePatient = jdbcTemplate.update(Constants.UPDATE_PATIENT_INFO,patient.getFirstName(),patient.getLastName(),
						patient.getAge(),patient.getDob(),patient.getMaritialStatus(),patient.getProfilePic(),patient.getGender(),
						patient.getPatientId());
				updateAddress = jdbcTemplate.update(Constants.UPDATE_ADDRESS_INFO,patient.getAddress().getMobile(),
						patient.getAddress().getEmail(),patient.getAddress().getStreet(),patient.getAddress().getCity(),
						patient.getAddress().getState(),patient.getAddress().getZipCode(),patient.getAddress().getEmergencyContactName(),
						patient.getAddress().getRelationShip(),patient.getAddress().getEmergencyContactMobile(),
						patient.getAddress().getPassword(),patient.getAddress().getAddressId());
				updateInsurance = jdbcTemplate.update(Constants.UPDATE_INSURANCE_INFO,patient.getInsuranceInfo().getProviderName(),
						patient.getInsuranceInfo().getPolicyNumber(),patient.getInsuranceInfo().getGroupNumber(),
						patient.getInsuranceInfo().getCoverageType(),patient.getInsuranceInfo().getEffectiveDate(),
						patient.getInsuranceInfo().getExpirationDate(),patient.getInsuranceInfo().getInsuranceInfoId());
				if(updatePatient > 0 || updateAddress > 0 || updateInsurance > 0) {
					return Constants.UPDATE_SUCCESS;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public List<Appointment> getPatientsActiveAppointments(String patientId) {
		List<Appointment> activeAppointments = null;
		try {
			activeAppointments =jdbcTemplate.query(Constants.GET_PATIENT_UPCOMING_APPOINTMENTS, new Object[]{patientId}, new AppointmentRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return activeAppointments;
	}
	
	public List<Appointment> getPatientPreviousAppointments(String patientId){
		List<Appointment> previous = null;
		try {
			previous = jdbcTemplate.query(Constants.GET_PATIENT_PREVIOUS_APPOINTMENTS, new Object[]{patientId}, new AppointmentRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return previous;
	}
	
	public List<Patient> getAllPatients(){
		List<Patient> patient = null;
		try {
			patient = jdbcTemplate.query(Constants.GET_ALL_PATIENTS, new PatientRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return patient;
	}
	
	public List<PatientAddressInfo> getAllPatientsAddress(){
		List<PatientAddressInfo> patientAddress = null;
		try {
			patientAddress = jdbcTemplate.query(Constants.GET_ALL_PATIENTS_ADDRESS, new PatientAddressRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return patientAddress;
	}
	
	public Cart getCart(String patientId) {
		Cart cart = null;
		try {
			cart = jdbcTemplate.queryForObject(Constants.GET_PATIENT_CART, new Object[] {patientId}, new CartRowMapper());
		}catch(EmptyResultDataAccessException ex) {}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public boolean addToCart(Cart c) {
		int insert = 0;
		int update = 0;
		try {
			if(null != getCart(c.getPatientId())) {
				insert = jdbcTemplate.update(Constants.UPDATE_ADD_TO_CART,c.getProducts(),c.getAdded_at(),c.getPatientId());
			}else {
				update = jdbcTemplate.update(Constants.ADD_TO_CART,c.getPatientId(),c.getProducts(),c.getAdded_at());
			}
			if(insert > 0 || update > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String placeOrder(CartOrders order) {
		int orderPlaced = 0;
		try {
			orderPlaced = jdbcTemplate.update(Constants.INSERT_ORDER,
					order.getPatientId(),order.getTotal_amount(),order.getOrder_status(),order.getCreated_at(),order.getProducts()
					);
			if(orderPlaced > 0) {
				order.getCart().setProducts(null);
				boolean addToCart = addToCart(order.getCart());
				if(addToCart) {
					return Constants.ORDER_PLACED;
				}
			}else {
				return Constants.ORDER_NOT_PLACED;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public List<CartOrders> getOrdersOfPatient(String patientId) {
		List<CartOrders> orders = null;
		try {
			orders = jdbcTemplate.query(Constants.GET_PATIENT_ORDERS, new Object[] {patientId}, new CartOrdersMapper());
		}catch(EmptyResultDataAccessException e) {
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
		
	}
	
//	
//	public PatientAddressInfo getPatientsAddress(){
//		PatientAddressInfo patientAddress = null;
//		try {
//			patientAddress = jdbcTemplate.queryForObject(Constants.GET_ALL_PATIENTS_ADDRESS, new PatientAddressRowMapper());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return patientAddress;
//	}

}
