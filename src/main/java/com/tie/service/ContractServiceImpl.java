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
        return contractRepository.findAll();
    }

    @Override
    public Contract findOne(String contractId) {
        return contractRepository.findOne(Integer.parseInt(contractId));
    }

}
