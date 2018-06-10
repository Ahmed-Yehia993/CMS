package com.tie.controller;

import com.tie.model.Contract;
import com.tie.model.User;
import com.tie.service.UserService;
import org.hibernate.Hibernate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tie.model.Contact;
import com.tie.model.Contract;
import com.tie.model.Deal;
import com.tie.model.Mag;
import com.tie.model.User;
import com.tie.service.ContactService;
import com.tie.service.ContactServiceImpl;
import com.tie.service.ContractService;
import com.tie.service.ContractServiceImpl;
import com.tie.service.DealService;
import com.tie.service.DealServiceImpl;
import com.tie.service.MagService;
import com.tie.service.MagServiceImpl;
import com.tie.service.UserService;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/contract/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser",  getCurrentUser());
        modelAndView.setViewName("contract_create");
        return modelAndView;
    }



    @RequestMapping(value = "/contract/{contractId}", method = RequestMethod.GET)
    public ModelAndView contractView(@PathVariable("contractId") String contractId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser",  getCurrentUser());
        Contract contract = contractService.findOne(contractId);
        Hibernate.initialize(contract.getContact());
        Hibernate.initialize(contract.getDeals());
        Hibernate.initialize(contract.getMags());
        System.out.println(contract.getContact());
        modelAndView.addObject("contract",contract);
        modelAndView.setViewName("contract_view");
        return modelAndView;
    }

    @RequestMapping(value = "/contract/{contractId}/edit", method = RequestMethod.GET)
    public ModelAndView contractEdit(@PathVariable("contractId") String contractId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contract",contractService.findOne(contractId));
        modelAndView.addObject("currentUser",  getCurrentUser());

        modelAndView.setViewName("contract_edit");
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
		Set<Deal> contractDeals = null;
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
				magService.saveMag(mag);
				contractMags.add(mag);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		contract.setMags(contractMags);

		for (int i = 0; i < deals.size(); i++) {
			DealService dealService = new DealServiceImpl();
			deal = new Deal();
			deal = dealService.findOneByName(deals.get(i));
			contractDeals.add(deal);
		}
		contract.setDeals(contractDeals);

		contract.setAccountNo(contractNumber);
		contract.setArea(Integer.parseInt(shopArea));
		contract.setDuration(Integer.parseInt(duration));
		contract.setHardCopyPath(fileUpload);
		try {
			contract.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(contractStart));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		contract.setStatus("Pending");
		contract.setType(contractType);

		contractService.saveContract(contract);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contract");
		return modelAndView;
	}

	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public ModelAndView contractList() {
		ModelAndView modelAndView = new ModelAndView();
		List<Contract> contracts = contractService.findAll();
		modelAndView.addObject("contracts", contracts);

		modelAndView.addObject("currentUser", getCurrentUser());

		modelAndView.setViewName("contract_list");
		return modelAndView;
	}




	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
}
