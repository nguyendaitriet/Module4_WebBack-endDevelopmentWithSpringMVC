package com.banking.service;

import com.banking.model.Location;
import com.banking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LocationService implements ILocationService{

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Iterable<Location> findAll() {
        return null;
    }

    @Override
    public Optional<Location> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Location getById(Long id) {
        return null;
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void remove(Long id) {

    }
}
