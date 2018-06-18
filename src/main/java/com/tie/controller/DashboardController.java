package com.tie.controller;

import com.tie.dto.ContractStatDto;
import com.tie.dto.ServicesStatDto;
import com.tie.model.Contract;
import com.tie.model.User;
import com.tie.service.ContractService;
import com.tie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    private UserService userService;

    @Autowired
    private ContractService contractService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser", getCurrentUser());
        List<Contract> contracts = contractService.findAll();
        ContractStatDto stat = contractService.getContractStat(contracts);
        ServicesStatDto serviceStat = contractService.getServiceStat(contracts);
        modelAndView.addObject("stat", stat);
        modelAndView.addObject("serviceStat", serviceStat);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        return user;
    }
}
