package com.tie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tie.model.Contact;
import com.tie.model.Contract;
import com.tie.model.Deal;
import com.tie.model.Mag;
import com.tie.service.ContactService;
import com.tie.service.ContactServiceImpl;
import com.tie.service.ContractService;
import com.tie.service.ContractServiceImpl;
import com.tie.service.MagService;
import com.tie.service.MagServiceImpl;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService = new ContractServiceImpl();

	@RequestMapping(value = "/contract/new", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contract_create");
		return modelAndView;
	}

	@RequestMapping(value = "/contract/new", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam("contractNumber") String contractNumber,
			@RequestParam("contractType") String contractType, @RequestParam("contractStart") String contractStart,
			@RequestParam("duration") String duration, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("emailAddress") String emailAddress,
			@RequestParam("zip") String zip, @RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("country") String country, @RequestParam("shopArea") String shopArea,
			@RequestParam("deals") ArrayList<String> deals, @RequestParam("mag[]") String[] mags,
			@RequestParam("fileUpload") String fileUpload) {

		ContactService contactService = new ContactServiceImpl();
		MagService magService = new MagServiceImpl();

		Contract contract = new Contract();
		Set<Contact> contacts = null;
		Contact contact = new Contact();
		Set<Deal> contractDeals;
		Deal deal;
		Set<Mag> contractMags = null;
		Mag mag;

		contact.setAddress(address);
		contact.setCity(city);
		contact.setCountry(country);
		contact.setEmailAddress(emailAddress);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setZipCode(zip);
		contactService.saveContact(contact);
		contacts.add(contact);
		contract.setContact(contacts);

		for (int i = 0; i < mags.length; i++) {
			mag = new Mag();
			mag.setAmount(Integer.parseInt(mags[i]));
			try {
				Calendar calendarStart = Calendar.getInstance();
				Calendar calendarEnd = Calendar.getInstance();
				calendarStart.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(contractStart));
				calendarStart.add(Calendar.YEAR, i);
				mag.setValidFrom(calendarStart.getTime());
				calendarEnd.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(contractStart));
				calendarEnd.add(Calendar.YEAR, i + 1);
				mag.setValidTo(calendarEnd.getTime());
				contractMags.add(mag);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		contract.setMags(contractMags);
		
		for (int i=0; i< deals.size(); i++) {
			
		}
		
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contract");
		return modelAndView;
	}

}
