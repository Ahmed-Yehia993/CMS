/**
 * 
 */
package com.tie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tie.model.Contact;

/**
 * @author Ahmed El-Deeb
 *
 */
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
