package com.medical.constants;

public class EmailConstants {
	
	public static final String EMAIL_Registration_SUCCESSFUL = "Medical Portal User Registration Successful ...";

	public static String getPatientRegistrationBody(String fullName, String userName, String email, String date) {
	    String PATIENT_REGISTRATION_CONTENT = String.format(
	            "Dear %s,%n%n" +
	            "Congratulations! Your registration with our Medical Portal has been successfully completed. Welcome to our healthcare community!%n%n" +
	            "Below are your registration details:%n%n" +
	            "- **Username:** %s%n" +
	            "- **Email Address:** %s%n" +
	            "- **Registration Date:** %s%n" +
	            "We are dedicated to providing you with comprehensive healthcare services and support. If you have any inquiries or require assistance, do not hesitate to contact our patient support team.%n%n" +
	            "Thank you for choosing our Med Portal. We are committed to offering you exceptional healthcare experiences.%n%n" +
	            "Best regards,%n" +
	            "Patient Portal Team%n" +
	            "Your Healthcare Provider%n" +
	            "Address Line%n" +
	            "Beaumont, Texas, 77705%n" +
	            "Phone: +1 123-456-7890%n" +
	            "Email: info@patientportal.com",
	            fullName, userName, email, date
	    );
	    return PATIENT_REGISTRATION_CONTENT;
	}

	
}
