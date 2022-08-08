package com.test.service;

import com.test.model.City;
import com.test.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public List<City> findAllByDeletedFalse() {
        return cityRepository.findAllByDeletedFalse();
    }

    public boolean existsByCityName(String cityName) {
        return cityRepository.existsByCityName(cityName);
    }

    public City save (City city) {
        return cityRepository.save(city);
    }

    public boolean existsByIdAndDeletedFalse(Long id) {
        return cityRepository.existsByIdAndDeletedFalse(id);
    }

    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    public boolean existsByCityNameAndIdIsNot(String name, Long id) {
        return cityRepository.existsByCityNameAndIdIsNot(name, id);
    }

}
