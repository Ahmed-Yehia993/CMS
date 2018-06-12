/**
 *
 */
package com.tie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tie.model.Contact;
import com.tie.model.Contract;
import com.tie.model.Mag;
import com.tie.repository.ContactRepository;
import com.tie.repository.ContractRepository;
import com.tie.repository.MagRepository;

/**
 * @author Ahmed El-Deeb
 */

@Service("contractService")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository contractRepository;
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private MagRepository magRepository;

	@Override
	public void saveContract(Contract contract) {

		for (Contact contact : contract.getContact()) {
			contactRepository.save(contact);
		}
		for (Mag mag : contract.getMags()) {
			magRepository.save(mag);
		}
		contractRepository.save(contract);
	}

	@Override
	public List<Contract> findAll() {
		return contractRepository.findAll(sortByIdAsc());
	}

	@Override
	public Contract findOne(String contractId) {
		return contractRepository.findOne(Integer.parseInt(contractId));
	}

	@Override
	public void update(Contract contract) {
		contractRepository.save(contract);
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "created");
	}
}
