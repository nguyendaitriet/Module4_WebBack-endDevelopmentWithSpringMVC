package com.banking.controller;

import com.banking.dto.CustomerDTO;
import com.banking.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showCustomerList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<CustomerDTO> customerList = customerService.findAllDTO();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        CustomerDTO newCustomerDTO = new CustomerDTO();
        modelAndView.addObject("newCustomerDTO", newCustomerDTO);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView crateCustomer(@ModelAttribute CustomerDTO newCustomer) {
        ModelAndView modelAndView = new ModelAndView("/create");
        String name = newCustomer.getFullName();
        String phone = newCustomer.getPhone();
        String email = newCustomer.getEmail();
        String address = newCustomer.getAddress();
        if (customerService.addNewCustomer(name,email,phone,address)) {
            modelAndView.addObject("success","Successful operation!");
        }
        else {
            modelAndView.addObject("failure","Failed operation!");
        }
        modelAndView.addObject("newCustomerDTO",new CustomerDTO());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        CustomerDTO currentCustomer = customerService.findCustomerDTOById(id);
        modelAndView.addObject("currentCustomer", currentCustomer);
        return modelAndView;
    }

}