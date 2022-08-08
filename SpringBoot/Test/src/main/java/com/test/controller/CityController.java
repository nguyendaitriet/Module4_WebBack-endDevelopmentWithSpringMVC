package com.test.controller;

import com.test.model.City;
import com.test.model.Nation;
import com.test.repository.NationRepository;
import com.test.service.CityService;
import com.test.util.ParsingValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    NationRepository nationRepository;

    @GetMapping("")
    public ModelAndView showCityList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<City> cityList = cityService.findAllByDeletedFalse();

        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        List<Nation> nationList = nationRepository.findAll();
        City newCity = new City();
        modelAndView.addObject("nationList", nationList);
        modelAndView.addObject("newCity", newCity);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView crateCustomer(@Validated @ModelAttribute("newCity") City newCity,
                                      @RequestParam long nationId,
                                      BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("create");

        Optional<Nation> nation = nationRepository.findById(nationId);
        List<Nation> nationList = nationRepository.findAll();

        String cityName = newCity.getCityName().trim();
        if (cityService.existsByCityName(cityName)) {
            bindingResult.addError(new ObjectError("cityNameExists", "City name has existed!"));
        }

        if (!nation.isPresent()) {
            bindingResult.addError(new ObjectError("nationNotFound", "Nation not found!"));
        }

        if (!bindingResult.hasErrors()) {
            try {
                newCity.setNation(nation.get());
                cityService.save(newCity);
                modelAndView.addObject("newCity", new City());
                modelAndView.addObject("success", "Successful operation!");
            } catch (Exception e) {
                modelAndView.addObject("failure", "Failed operation!");
                modelAndView.addObject("newCity", newCity);
            }
        }
        else {
            modelAndView.addObject("hasError", true);
        }

        modelAndView.addObject("nationList", nationList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        return dispatchRequest(modelAndView, id);
    }

    @GetMapping("/suspend/{id}")
    public ModelAndView showSuspendForm(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("suspend");
        return dispatchRequest(modelAndView, id);
    }

    private ModelAndView dispatchRequest(ModelAndView modelAndView, String id) {
        if (ParsingValidationUtils.isLongParsable(id)) {
            long validId = Long.parseLong(id);
            if (cityService.existsByIdAndDeletedFalse(validId)) {
                List<Nation> nationList = nationRepository.findAll();
                City newCity = cityService.findById(validId).get();
                modelAndView.addObject("nationList", nationList);
                modelAndView.addObject("newCity", newCity);
                return modelAndView;
            }
        }

        modelAndView.addObject("newCity", new City());
        modelAndView.addObject("wrongId","City ID doesn't exist!");
        return modelAndView;
    }

    @PostMapping("/suspend/{id}")
    public ModelAndView suspendCustomer(@PathVariable String id,
                                        @RequestParam long nationId,
                                        @ModelAttribute("newCity") City newCity) {
        ModelAndView modelAndView = new ModelAndView("/suspend");
        Optional<Nation> nation = nationRepository.findById(nationId);
        List<Nation> nationList = nationRepository.findAll();

        if(ParsingValidationUtils.isLongParsable(id)) {
            long validId = Long.parseLong(id);
            if (cityService.existsByIdAndDeletedFalse(validId)) {
                newCity.setId(validId);
                newCity.setDeleted(true);
                newCity.setNation(nation.get());
                cityService.save(newCity);
                modelAndView.addObject("success", "Successful operation!");
                modelAndView.addObject("newCity", newCity);
                modelAndView.addObject("nationList", nationList);
                return modelAndView;
            }
        }

        modelAndView.addObject("newCity", new City());
        modelAndView.addObject("wrongId", "City ID doesn't exist!");

        return modelAndView;
    }


    @PostMapping("/edit/{id}")
    public ModelAndView updateCustomer(@PathVariable String id,
                                       @Validated @ModelAttribute("newCity") City newCity,
                                       @RequestParam long nationId,
                                       BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("/edit");

        Optional<Nation> nation = nationRepository.findById(nationId);
        List<Nation> nationList = nationRepository.findAll();

        if (ParsingValidationUtils.isLongParsable(id)) {
            long validId = Long.parseLong(id);
            if (cityService.existsByIdAndDeletedFalse(validId)) {

                if (cityService.existsByCityNameAndIdIsNot(newCity.getCityName(), validId)) {
                    bindingResult.addError(new ObjectError("cityNameExists", "City name has existed!"));
                }

                if (!bindingResult.hasErrors()) {

                    try {
                        newCity.setId(validId);
                        newCity.setNation(nation.get());
                        modelAndView.addObject("newCity", cityService.save(newCity));
                        modelAndView.addObject("success", "Successful operation!");
                        modelAndView.addObject("nationList", nationList);
                    } catch (Exception e) {
                        modelAndView.addObject("failure", "Failed operation!");
                        modelAndView.addObject("nationList", nationList);
                        modelAndView.addObject("newCity", newCity);
                    }

                } else {

                    modelAndView.addObject("hasError", true);
                }

                return modelAndView;
            }
        }

        modelAndView.addObject("newCity", new City());
        modelAndView.addObject("wrongId", "City ID doesn't exist!");
        return modelAndView;

    }


}
