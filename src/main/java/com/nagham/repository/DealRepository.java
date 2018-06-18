/**
 * 
 */
package com.nagham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagham.model.Deal;

/**
 * @author Ahmed El-Deeb
 *
 */
@Repository("dealRepository")
public interface DealRepository extends JpaRepository<Deal, Long> {

	Deal findByName(String name);
}
