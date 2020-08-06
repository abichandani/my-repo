package com.infybank.api;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybank.dto.BranchDTO;
import com.infybank.exceptions.InfyBankBranchException;
import com.infybank.service.BranchService;

@Validated
@RestController
@RequestMapping("/")
public class BranchAPI {
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping("create")
	public BranchDTO addBranch(@Valid @RequestBody BranchDTO branchDTO) throws InfyBankBranchException {
		// TODO Auto-generated method stub
		return branchService.addBranch(branchDTO);
	}
	
	@RequestMapping("locate")
	@GetMapping
	public List<BranchDTO> locateBranches(
			@Range(min=100000, max=999999, message="{branch.pincode.invalid}") long pinCode
										) throws InfyBankBranchException {
		
		return branchService.locateBranches(pinCode);
	}

}
