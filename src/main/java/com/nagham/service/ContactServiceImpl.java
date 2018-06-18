/**
 * 
 */
package com.nagham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagham.model.Contact;
import com.nagham.repository.ContactRepository;

/**
 * @author Ahmed El-Deeb
 *
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
