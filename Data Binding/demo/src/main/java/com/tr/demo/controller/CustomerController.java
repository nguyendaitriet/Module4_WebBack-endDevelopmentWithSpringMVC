package com.tr.demo.controller;

import com.tr.demo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("/demo");
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1, "Ha"));
        customerList.add(new Customer(2, "Phuong"));
        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("");

        return new ModelAndView();
    }
}
