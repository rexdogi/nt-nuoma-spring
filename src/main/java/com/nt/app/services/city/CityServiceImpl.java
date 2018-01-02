package com.nt.app.services.city;

import com.nt.app.persistence.jpadao.CityRepository;
import com.nt.app.persistence.model.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public List<City> findByLanguage() {
        return cityRepository.findByLanguage();
    }
}
