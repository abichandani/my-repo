package com.infybank.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Branch")
public class BranchEntity {
	
	@Id
	@Column(name="Branch_Code")
	private Integer branchCode;
	
	@Column(name="Opening_Time")
	private LocalTime openingTime;
	
	@Column(name="Closing_Time")
	private LocalTime closingTime;

	@Column(name="Ifsc_Code")
	private String ifscCode;
	
	@Column(name="Branch_Type")
	private String branchType;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Pincode")
	private Long pinCode;
	
	@Column(name="Phone_Number")
	private Long phoneNumber;
	
	@Column(name="Email_Id")
	private String emailId;
	
	@Column(name="Status")
	private String status;
	
	
	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
