package com.nagham.controller;

import com.nagham.dto.ContractStatDto;
import com.nagham.dto.ServicesStatDto;
import com.nagham.model.Contract;
import com.nagham.model.Deal;
import com.nagham.model.Package;
import com.nagham.model.Role;
import com.nagham.repository.DealRepository;
import com.nagham.repository.PackageRepository;
import com.nagham.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class InitController {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    DealRepository dealRepository;

    @RequestMapping(value = {"/initApp"}, method = RequestMethod.GET)
    public String initApp() {
        Role role = new Role();
        role.setId(1);
        role.setRole("ADMIN");
        roleRepository.save(role);

        role.setId(2);
        role.setRole("USER");
        roleRepository.save(role);

        Deal d1 = new Deal();
        d1.setId(1);
        d1.setName("bac_iptv_monthly");
        d1.setPoid("4272156");
        d1 = dealRepository.save(d1);


        Deal d2 = new Deal();
        d2.setId(2);
        d2.setName("bac_util_power");
        d2.setPoid("4461432");
        d2 = dealRepository.save(d2);


        Deal d3 = new Deal();
        d3.setId(3);
        d3.setName("bac_util_water");
        d3.setPoid("4463480");
        d3 = dealRepository.save(d3);


        Deal d4 = new Deal();
        d4.setId(4);
        d4.setName("bac_retail_annually_lag");
        d4.setPoid("3782842");
        d4 = dealRepository.save(d4);


        Deal d5 = new Deal();
        d5.setId(5);
        d5.setName("bac_retail_monthly_lag");
        d5.setPoid("3781818");
        d5 = dealRepository.save(d5);


        Deal d6= new Deal();
        d6.setId(6);
        d6.setName("bac_retail_mag");
        d6.setPoid("3783866");
        d6 = dealRepository.save(d6);


        Deal d7= new Deal();
        d7.setId(7);
        d7.setName("bac_rental_monthly");
        d7.setPoid("4309250");
        d7 = dealRepository.save(d7);


        Package p = new Package();
        p.setId(1);
        p.setName("Rental");
        Set<Deal>deals = new HashSet<>();
        deals.add(d7);
        p.setDeals(deals);
        packageRepository.save(p);

        Package p2 = new Package();
        p2.setId(2);
        p2.setName("Retail Revenue Sharing");
        Set<Deal>deals2 = new HashSet<>();
        deals2.add(d4);
        deals2.add(d5);
        deals2.add(d6);
        p2.setDeals(deals2);
        packageRepository.save(p2);

        Package p3 = new Package();
        p3.setId(3);
        p3.setName("IPTV");
        Set<Deal>deals3 = new HashSet<>();
        deals3.add(d1);
        p3.setDeals(deals3);
        packageRepository.save(p3);

        Package p4 = new Package();
        p4.setId(4);
        p4.setName("Power");
        Set<Deal>deals4 = new HashSet<>();
        deals4.add(d2);
        p4.setDeals(deals4);
        packageRepository.save(p4);

        Package p5 = new Package();
        p5.setId(5);
        p5.setName("Water");
        Set<Deal>deals5 = new HashSet<>();
        deals5.add(d3);
        p5.setDeals(deals);
        packageRepository.save(p5);



        return "redirect:/";
    }
}