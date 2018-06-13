/**
 * 
 */
package com.tie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tie.model.Deal;

import java.util.Set;

/**
 * @author Ahmed El-Deeb
 *
 */
@Repository("dealRepository")
public interface DealRepository extends JpaRepository<Deal, Long> {

	Deal findByName(String name);
}
