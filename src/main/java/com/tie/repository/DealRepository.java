/**
 * 
 */
package com.tie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tie.model.Deal;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface DealRepository extends JpaRepository<Deal, Long> {

}
