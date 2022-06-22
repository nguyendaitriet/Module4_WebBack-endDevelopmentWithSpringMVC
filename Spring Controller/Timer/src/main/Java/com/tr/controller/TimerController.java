package com.tr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimerController {

    @GetMapping(value = "/world-clock")
    public ModelAndView getTime(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        ModelAndView timer = new ModelAndView("index");
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        timer.addObject("city", city);
        timer.addObject("date", date);
        return timer;
    }
}
