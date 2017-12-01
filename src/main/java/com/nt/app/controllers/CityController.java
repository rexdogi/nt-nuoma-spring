package com.nt.app.controllers;


import com.nt.app.persistence.dao.CityRepository;
import com.nt.app.persistence.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> index() {
        return cityRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<City> store(@RequestBody City city) {
        cityRepository.save(city);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public City edit(@PathVariable Long id) {
        System.out.println(id);
        return cityRepository.findOne(id);
    }

    @PutMapping
    public ResponseEntity<City> update(@RequestBody City city) {
        if(city != null) {
            cityRepository.save(city);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<City> update(@PathVariable Long id) {
        City city = cityRepository.findOne(id);
        if(city != null) {
            cityRepository.delete(city);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
