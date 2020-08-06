package com.infybank.dto;

import java.time.LocalTime;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class BranchUpdateDTO {
	
	@Range(min=1000, message="{branch.code.invalid}")
	private Integer branchCode;
	
	private LocalTime openingTime;
	
	private LocalTime closingTime;
	
	@Pattern(regexp = "Retail|Commercial|Overseas", message = "{branch.type.invalid}")
	private String branchType;
	
	private Long phoneNumber;
	
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

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
