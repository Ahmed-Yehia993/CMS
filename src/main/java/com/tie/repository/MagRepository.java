/**
 * 
 */
package com.tie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tie.model.Mag;

/**
 * @author Ahmed El-Deeb
 *
 */
@Repository("magRepository")
public interface MagRepository extends JpaRepository<Mag, Integer> {

}
