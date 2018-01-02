package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT c FROM City c " +
            "LEFT JOIN c.translations ct "+
            "ON ct.title = '1'")
    List<City> findByLanguage();

    List<City> findAll();

    City findOne(Long id);

    City save(City city);

    void delete(Long id);

}
