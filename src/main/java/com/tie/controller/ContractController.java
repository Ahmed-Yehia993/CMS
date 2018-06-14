package com.tie.controller;

import com.tie.consume.ws.BRMCaller;
import com.tie.model.*;
import com.tie.model.Package;
import com.tie.service.ContractService;
import com.tie.service.DealService;
import com.tie.service.PackageService;
import com.tie.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private UserService userService;
    @Autowired
    private PackageService packageService;

    @Autowired
    private DealService dealService;
    //Save the uploaded file to this folder
//    private static String UPLOADED_FOLDER = "C://WORK//CMS//src//main//resources//static//assets//uploadedFiles//";

    private static String UPLOADED_FOLDER = "D://Workspace//idea//CMS//src//main//resources//static//assets//uploadedFiles//";


    @RequestMapping(value = "/contract/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.setViewName("contract_create");
        return modelAndView;
    }

    @RequestMapping(value = "/contract/{contractId}", method = RequestMethod.GET)
    public ModelAndView contractView(@PathVariable("contractId") String contractId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentUser", getCurrentUser());
        Contract contract = contractService.findOne(contractId);
        Hibernate.initialize(contract.getContact());
        Hibernate.initialize(contract.getPackages());
        Hibernate.initialize(contract.getMags());
        System.out.println(contract.getContact());
        modelAndView.addObject("contract", contract);
        modelAndView.setViewName("contract_view");
        return modelAndView;
    }

    @RequestMapping(value = "/contract/{contractId}/edit", method = RequestMethod.GET)
    public ModelAndView contractEdit(@PathVariable("contractId") String contractId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contract", contractService.findOne(contractId));
        modelAndView.addObject("currentUser", getCurrentUser());

        modelAndView.setViewName("contract_edit");
        return modelAndView;
    }

    @RequestMapping(value = "/contract/new", method = RequestMethod.POST)
    public String create(@RequestParam("contractNumber") String contractNumber,
                         @RequestParam("contractType") String contractType,
                         @RequestParam("contractStart") String contractStart,
                         @RequestParam("duration") String duration,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("emailAddress") String emailAddress,
                         @RequestParam("zip") String zip,
                         @RequestParam("address") String address,
                         @RequestParam("city") String city,
                         @RequestParam("country") String country,
                         @RequestParam("shopArea") String shopArea,
                         @RequestParam("companyName") String companyName,
                         @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam(value = "deals", required = true) String[] deals,
                         @RequestParam(value = "mag[]", required = true) String[] mags,
                         @RequestParam("file") MultipartFile file
    ) {
        System.out.println(contractNumber);
        System.out.println(contractType);
        System.out.println(contractStart);
        System.out.println(duration);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(emailAddress);
        System.out.println(zip);
        System.out.println(address);
        System.out.println(city);
        System.out.println(country);
        System.out.println(shopArea);
//		System.out.println(deals[1]);
//		System.out.println(mags[1]);

        Contract contract = new Contract();
        Set<Contact> contacts = new HashSet<>();
        Contact contact = new Contact();
        Set<Package> contractPackages = new HashSet<>();
        Package aPackage;
        Set<Mag> contractMags = new HashSet<>();
        Mag mag;
        contact.setAddress(address);
        contact.setCity(city);
        contact.setCountry(country);
        contact.setEmailAddress(emailAddress);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setZipCode(zip);
        contact.setPhoneNumber(phoneNumber);
        contacts.add(contact);
        contract.setContact(contacts);

        for (int i = 1; i < mags.length; i++) {
            mag = new Mag();
            mag.setAmount(Integer.parseInt(mags[i]));
            try {
                Calendar calendarStart = Calendar.getInstance();
                Calendar calendarEnd = Calendar.getInstance();
                calendarStart.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(contractStart));
                calendarStart.add(Calendar.YEAR, i - 1);
                mag.setValidFrom(calendarStart.getTime());
                calendarEnd.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(contractStart));
                calendarEnd.add(Calendar.YEAR, i);
                mag.setValidTo(calendarEnd.getTime());
                contractMags.add(mag);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        contract.setMags(contractMags);

        for (int i = 0; i < deals.length; i++) {
            aPackage = new Package();
            aPackage = packageService.findByName(deals[i]);
            contractPackages.add(aPackage);
        }
        contract.setPackages(contractPackages);

        contract.setAccountNo(contractNumber);
        contract.setArea(Integer.parseInt(shopArea));
        contract.setDuration(Integer.parseInt(duration));
        contract.setCompanyName(companyName);
        try {
            contract.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(contractStart));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        contract.setStatus(String.valueOf(ContractStatus.PENDING));
        contract.setType(contractType);
        System.out.println(contract);

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                contract.setHardCopyPath(file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        contractService.saveContract(contract);

        return "redirect:/contract";
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


    @RequestMapping(value = "/contract/{contractId}/approve", method = RequestMethod.GET)
    public String approve(@PathVariable("contractId") String contractId) {


        Contract contract = contractService.findOne(contractId);
        contract.setStatus(String.valueOf(ContractStatus.ACTIVE));
        Hibernate.initialize(contract.getContact());
        Hibernate.initialize(contract.getPackages());
        Hibernate.initialize(contract.getMags());

        // ConsumeCustomerService consumeCustomerService = new ConsumeCustomerService();
        // consumeCustomerService.createCustomerService(contract);

        BRMCaller brmCaller = new BRMCaller();
        try {
            brmCaller.createBrmAccount(contract);
            contractService.update(contract);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return "redirect:/contract";
    }

    @RequestMapping(value = "/contract/{contractId}/reject", method = RequestMethod.GET)
    public String reject(@PathVariable("contractId") String contractId) {

        Contract contract = contractService.findOne(contractId);
        contract.setStatus(String.valueOf(ContractStatus.REJECTED));
        contractService.update(contract);

        return "redirect:/contract";
    }

    @RequestMapping(value = "/contract/file/download", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadFile(@Param(value = "id") String id) throws FileNotFoundException {
        Contract product = contractService.findOne(id);

        File file = new File(UPLOADED_FOLDER + product.getHardCopyPath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName()).contentLength(file.length())
                .body(resource);
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        return user;
    }

}
