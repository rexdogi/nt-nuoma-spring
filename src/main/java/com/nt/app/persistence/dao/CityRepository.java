package com.nt.app.persistence.dao;

import com.nt.app.persistence.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}
