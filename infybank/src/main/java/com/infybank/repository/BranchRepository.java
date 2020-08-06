package com.infybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infybank.entity.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{
	
	@Query("select max(branchCode) from BranchEntity")
	Integer getMaxBranchCode();
	
	List<BranchEntity> findByAddress(String address);
	
	List<BranchEntity> findByPinCode(Long pinCode);
	
	List<BranchEntity> findByPhoneNumber(Long phoneNumber);
	
}