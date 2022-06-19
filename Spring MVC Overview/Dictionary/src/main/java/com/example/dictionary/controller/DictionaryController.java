package com.example.dictionary.controller;

import com.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public ModelAndView showList() {
        return new ModelAndView("form");
    }

    @PostMapping("/lookup")
    public ModelAndView calculate(@RequestParam String inputWord) {
        ModelAndView modelAndView = new ModelAndView("form");
       String input = inputWord.toLowerCase().trim();
       String result = dictionaryService.lookUp(input);
       modelAndView.addObject("inputWord",inputWord);
       if (result == null) {
           modelAndView.addObject("result","Word not found!");
       } else {
           modelAndView.addObject("result", result);
       }
        return modelAndView;
    }

}