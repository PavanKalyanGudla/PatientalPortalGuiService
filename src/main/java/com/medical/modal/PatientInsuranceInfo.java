package com.medical.modal;

public class PatientInsuranceInfo {
	private String insuranceInfoId;
    private String patientId;	
	private String providerName;
	private String policyNumber;
	private String groupNumber;
	private String coverageType;
	private String effectiveDate;
	private String expirationDate;
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getCoverageType() {
		return coverageType;
	}
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getInsuranceInfoId() {
		return insuranceInfoId;
	}
	public void setInsuranceInfoId(String insuranceInfoId) {
		this.insuranceInfoId = insuranceInfoId;
	}
}
