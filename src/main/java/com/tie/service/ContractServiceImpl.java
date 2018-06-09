/**
 * 
 */
package com.tie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tie.model.Contract;
import com.tie.repository.ContractRepository;

/**
 * @author Ahmed El-Deeb
 *
 */

@Service("contractService")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository contractRepository;

	@Override
	public void saveContract(Contract contract) {
		contractRepository.save(contract);
	}

	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract findOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
