package com.infybank.service;

import java.util.List;

import com.infybank.dto.BranchDTO;
import com.infybank.dto.BranchUpdateDTO;
import com.infybank.exceptions.InfyBankBranchException;

public interface BranchService {
	
	BranchDTO addBranch(BranchDTO branchDTO) throws InfyBankBranchException;
	
	List<BranchDTO> locateBranches(Long pincode) throws InfyBankBranchException;
	
	BranchDTO updateBranch(BranchUpdateDTO branchUpdateDTO) throws InfyBankBranchException;
	
	String deleteBranch(Integer branchCode) throws InfyBankBranchException;

}
