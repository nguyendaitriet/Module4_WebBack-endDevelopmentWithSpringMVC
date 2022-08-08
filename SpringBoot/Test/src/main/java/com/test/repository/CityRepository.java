package com.test.repository;

import com.test.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByDeletedFalse();

    boolean existsByCityName(String cityName);

    boolean existsByIdAndDeletedFalse(Long id);

    boolean existsByCityNameAndIdIsNot(String name, Long id);

}
