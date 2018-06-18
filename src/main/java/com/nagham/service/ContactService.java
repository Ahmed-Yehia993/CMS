/**
 * 
 */
package com.nagham.service;

import java.util.List;

import com.nagham.model.Contact;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface ContactService {
	public void saveContact(Contact contact);
	public List<Contact> findAll();
	Contact findOne();
}
