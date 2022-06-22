package com.example.demo.controller;

import com.example.demo.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class DemoController {

    @RequestMapping("demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("message", "Triet");
        Customer customer = new Customer(12943,"Rodals Marcus");
        ArrayList<Customer> customersList = new ArrayList<>();
        customersList.add(new Customer(345245,"Nam"));
        customersList.add(new Customer(324543,"Hoa"));
        customersList.add(new Customer(345245,"Trung"));
        customersList.add(new Customer(345245,"Hai"));
        customersList.add(new Customer(345245,"Thu"));
        modelAndView.addObject("customersList", customersList);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
