package com.tie.service;

import java.util.List;

import com.tie.dto.ContractStatDto;
import com.tie.dto.ServicesStatDto;
import com.tie.model.Contract;

public interface ContractService {
	public void saveContract(Contract contract);
	public List<Contract> findAll();
	Contract findOne(String contractId);
	public void update(Contract contract);

    ContractStatDto getContractStat(List<Contract>contracts);

	ServicesStatDto getServiceStat(List<Contract> contracts);
}
