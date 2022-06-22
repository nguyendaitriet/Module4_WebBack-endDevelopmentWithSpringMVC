package com.tr.demo.controller;

import com.tr.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final List<User> userList = new ArrayList<User>();

    @GetMapping("/form")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        User newUser = new User();
        modelAndView.addObject("newUser", newUser);
        modelAndView.addObject("genderList", new String[]{"Male", "Female", "Other"});
        modelAndView.addObject("hobbyList", new String[]{"Traveling", "Skiing", "Jogging", "Singing", "cycling"});
        modelAndView.addObject("typeList", new String[]{"International", "Native"});
        modelAndView.addObject("countryList", new String[]{"Cambodia", "England", "Germany", "VietNam", "Japan"});
        return modelAndView;
    }

    @GetMapping("/showList")
    public ModelAndView showUserList() {
        ModelAndView modelAndView = new ModelAndView("/demo");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

    @PostMapping("/createUser")
    public ModelAndView save(@ModelAttribute User newUser){
        ModelAndView modelAndView = new ModelAndView("/demo");
        userList.add(newUser);
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

}
