package com.infybank.dto;

import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.infybank.entity.BranchEntity;

public class BranchDTO {
	
	private Integer branchCode;
	
	@NotNull(message = "{branch.openingtime.invalid}")
	private LocalTime openingTime;
	
	@NotNull(message = "{branch.closingtime.invalid}")
	private LocalTime closingTime;

	private String ifscCode;
	
	@NotNull(message = "{branch.type.notpresent}")
	@Pattern(regexp="Retail|Commercial|Overseas", 
			message="{branch.type.invalid}")
	private String branchType;
	
	@Pattern(regexp="[\\S][\\S\\s]+", message="{branch.address.invalid}")
	private String address;
	
	@Range(min=100000, max=999999, message="{branch.pincode.invalid}")
	private Long pinCode;
	
	@Range(min=1000000000, max=Long.MAX_VALUE, message="{branch.phoneNumber.invalid}")
	private Long phoneNumber;
	
	private String emailId;
	
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
	
	public static BranchEntity getEntity(BranchDTO branchDTO) {
		BranchEntity branchEntity = new BranchEntity();
		branchEntity.setAddress(branchDTO.address);
		branchEntity.setBranchCode(branchDTO.branchCode);
		branchEntity.setBranchType(branchDTO.branchType);
		branchEntity.setClosingTime(branchDTO.closingTime);
		branchEntity.setOpeningTime(branchDTO.openingTime);
		branchEntity.setEmailId(branchDTO.emailId);
		branchEntity.setIfscCode(branchDTO.ifscCode);
		branchEntity.setPhoneNumber(branchDTO.phoneNumber);
		branchEntity.setPinCode(branchDTO.pinCode);
		branchEntity.setStatus(branchDTO.status);
		
		return branchEntity;
	}
	
	public static BranchDTO getDTO(BranchEntity branchEntity) {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setAddress(branchEntity.getAddress());
		branchDTO.setBranchCode(branchEntity.getBranchCode());
		branchDTO.setBranchType(branchEntity.getBranchType());
		branchDTO.setClosingTime(branchEntity.getClosingTime());
		branchDTO.setOpeningTime(branchEntity.getOpeningTime());
		branchDTO.setEmailId(branchEntity.getEmailId());
		branchDTO.setIfscCode(branchEntity.getIfscCode());
		branchDTO.setPhoneNumber(branchEntity.getPhoneNumber());
		branchDTO.setPinCode(branchEntity.getPinCode());
		branchDTO.setStatus(branchEntity.getStatus());
		
		return branchDTO;
	}

}
