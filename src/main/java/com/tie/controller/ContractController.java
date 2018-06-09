package com.tie.controller;

import com.tie.model.Contract;
import com.tie.model.User;
import com.tie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tie.service.ContractService;

import java.util.List;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/contract/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contract_create");
        return modelAndView;
    }

    @RequestMapping(value = "/contract", method = RequestMethod.GET)
    public ModelAndView contractList() {
        ModelAndView modelAndView = new ModelAndView();
        List<Contract> contracts = contractService.findAll();
        modelAndView.addObject("contracts", contracts);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser",  user);

        modelAndView.setViewName("contract_list");
        return modelAndView;
    }

    @RequestMapping(value = "/contract/{contractId}", method = RequestMethod.GET)
    public ModelAndView contractView(@PathVariable("contractId") String contractId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contract",contractService.findOne(contractId));
        modelAndView.setViewName("contract_view");
        return modelAndView;
    }

    @RequestMapping(value = "/contract/{contractId}/edit", method = RequestMethod.GET)
    public ModelAndView contractEdit(@PathVariable("contractId") String contractId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contract",contractService.findOne(contractId));
        modelAndView.setViewName("contract_edit");
        return modelAndView;
    }
}
