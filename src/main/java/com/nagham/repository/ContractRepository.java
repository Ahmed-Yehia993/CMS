/**
 * 
 */
package com.nagham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagham.model.Contract;

/**
 * @author Ahmed El-Deeb
 *
 */
@Repository("contractRepository")
public interface ContractRepository extends JpaRepository<Contract, Integer> {
	
}
