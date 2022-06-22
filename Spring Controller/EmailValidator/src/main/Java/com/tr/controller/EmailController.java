package com.tr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Pattern;

@Controller
public class EmailController {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/validate")
    public ModelAndView validateEmail(@RequestParam String inputEmail) {
        ModelAndView validator = new ModelAndView();
        if (!isEmailValid(inputEmail)) {
            validator.setViewName("home");
            validator.addObject("message","Invalid email address!");
            return validator;
        }
        validator.setViewName("success");
        validator.addObject("email",inputEmail);
        return validator;
    }

    public static boolean isEmailValid(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

}
