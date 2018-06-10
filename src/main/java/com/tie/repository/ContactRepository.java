/**
 * 
 */
package com.tie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tie.model.Contact;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
