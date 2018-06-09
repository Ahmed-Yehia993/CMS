package com.tie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tie.service.ContractService;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;

	@RequestMapping(value = "/contract/new", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contract_create");
		return modelAndView;
	}
}
