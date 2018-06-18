/**
 *
 */
package com.nagham.service;

import java.util.List;

import com.nagham.dto.ContractStatDto;
import com.nagham.dto.ServicesStatDto;
import com.nagham.model.ContractStatus;
import com.nagham.model.Package;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nagham.model.Contact;
import com.nagham.model.Contract;
import com.nagham.model.Mag;
import com.nagham.repository.ContactRepository;
import com.nagham.repository.ContractRepository;
import com.nagham.repository.MagRepository;

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
        return contractRepository.findAll(sortByIdDESC());
    }

    @Override
    public Contract findOne(String contractId) {
        return contractRepository.findOne(Integer.parseInt(contractId));
    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public ContractStatDto getContractStat(List<Contract> contracts) {
        ContractStatDto contractStatDto = new ContractStatDto();
        int pend = 0, active = 0, reject = 0;
        for (Contract c : contracts) {
            if (c.getStatus().equals(String.valueOf(ContractStatus.PENDING))) {
                pend++;
                contractStatDto.setPendingContract(pend);
            }
            if (c.getStatus().equals(String.valueOf(ContractStatus.ACTIVE))) {
                active++;
                contractStatDto.setApprovedContract(active);
            }
            if (c.getStatus().equals(String.valueOf(ContractStatus.REJECTED))) {
                reject++;
                contractStatDto.setRejectedContract(reject);
            }
            contractStatDto.setSum(pend + active + reject);
            contractStatDto.setRejectedContract(reject);
            contractStatDto.setApprovedContract(active);
            contractStatDto.setPendingContract(pend);
        }
        contractStatDto.setDataPercent(((float) contractStatDto.getApprovedContract() / (float) contractStatDto.getSum()) * 100);


        return contractStatDto;
    }

    @Override
    public ServicesStatDto getServiceStat(List<Contract> contracts) {
        ServicesStatDto servicesStatDto = new ServicesStatDto();
        int rentalCount = 0,
                retailRevenueSharingCount = 0,
                iPTVCount = 0,
                powerCount = 0,
                waterCount = 0;
        for (Contract c : contracts) {
            Hibernate.initialize(c.getPackages());
            for (Package p : c.getPackages()) {
                if (p.getName().equals("Rental")) {
                    rentalCount++;
                }
                if (p.getName().equals("Retail Revenue Sharing")) {
                    retailRevenueSharingCount++;
                }
                if (p.getName().equals("IPTV")) {
                    iPTVCount++;
                }
                if (p.getName().equals("Power")) {
                    powerCount++;
                }
                if (p.getName().equals("Water")) {
                    waterCount++;
                }
            }

        }
        servicesStatDto.setiPTVCount(iPTVCount);
        servicesStatDto.setPowerCount(powerCount);
        servicesStatDto.setRentalCount(rentalCount);
        servicesStatDto.setRetailRevenueSharingCount(retailRevenueSharingCount);
        servicesStatDto.setWaterCount(waterCount);
        return servicesStatDto;
    }

    private Sort sortByIdDESC() {
        return new Sort(Sort.Direction.DESC, "created");
    }
}
