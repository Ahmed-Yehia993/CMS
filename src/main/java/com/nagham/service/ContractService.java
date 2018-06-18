package com.nagham.service;

import java.util.List;

import com.nagham.dto.ContractStatDto;
import com.nagham.dto.ServicesStatDto;
import com.nagham.model.Contract;

public interface ContractService {
	public void saveContract(Contract contract);
	public List<Contract> findAll();
	Contract findOne(String contractId);
	public void update(Contract contract);

    ContractStatDto getContractStat(List<Contract>contracts);

	ServicesStatDto getServiceStat(List<Contract> contracts);
}
