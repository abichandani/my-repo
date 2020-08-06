package com.infybank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.infybank.dto.BranchDTO;
import com.infybank.dto.BranchUpdateDTO;
import com.infybank.entity.BranchEntity;
import com.infybank.exceptions.InfyBankBranchException;
import com.infybank.repository.BranchRepository;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	private BranchRepository branchRepository;
	
//	@Autowired
//	private Environment environment;

	@Override
	public BranchDTO addBranch(BranchDTO branchDTO) throws InfyBankBranchException {
		// TODO Auto-generated method stub
		
		BranchEntity branchEntity = BranchDTO.getEntity(branchDTO);
		branchRepository.save(branchEntity);
		
		branchDTO = new BranchDTO();
		branchDTO.setBranchCode(branchEntity.getBranchCode());
		branchDTO.setStatus("A");
		
		return branchDTO;
	}

	@Override
	public List<BranchDTO> locateBranches(Long pinCode) throws InfyBankBranchException {
		// TODO Auto-generated method stub
		List<BranchEntity> branchesFromRepo =  branchRepository.findByPinCode(pinCode);
		
		if (branchesFromRepo.isEmpty()) {
			throw new InfyBankBranchException("No Branches Found.");
		}
		
		List<BranchDTO> branchesDTO = new ArrayList<BranchDTO>();
		
		for (BranchEntity branchEntity : branchesFromRepo) {
			branchesDTO.add(BranchDTO.getDTO(branchEntity));
		}
		return branchesDTO;
	}

	@Override
	public BranchDTO updateBranch(BranchUpdateDTO branchUpdateDTO) throws InfyBankBranchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBranch(Integer branchCode) throws InfyBankBranchException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
