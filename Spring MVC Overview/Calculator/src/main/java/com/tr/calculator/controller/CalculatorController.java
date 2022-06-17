package com.tr.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Controller
public class CalculatorController {


    @GetMapping("/calculator")
    public ModelAndView showList() {
        return new ModelAndView("/views/index.jsp");
    }

    @PostMapping("/calculator")
    public ModelAndView calculate(@RequestParam BigDecimal value, @RequestParam int choice) {
        ModelAndView modelAndView = new ModelAndView("/views/index.jsp");
        BigDecimal result;
        switch (choice) {
            case 1:
                result = value.divide(new BigDecimal(23000),4, RoundingMode.CEILING);
                break;
            case 2:
                result = value.multiply(new BigDecimal(23000));
                break;
            default:
                result = new BigDecimal(0);
                break;
        }
        modelAndView.addObject("value", value);
        modelAndView.addObject("result", result);
        return modelAndView;
    }

}