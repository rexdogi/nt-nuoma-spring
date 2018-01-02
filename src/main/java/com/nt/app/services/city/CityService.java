package com.nt.app.services.city;


import com.nt.app.persistence.model.city.City;
import com.nt.app.services.CrudService;

import java.util.List;

public interface CityService extends CrudService<City> {

    List<City> findByLanguage();
}
