package com.nt.app.controllers;

import com.nt.app.persistence.dao.PropertyRepository;
import com.nt.app.persistence.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @PostMapping("/create")
    public void create(@Valid @RequestBody Property property) {
        propertyRepository.save(property);
    }
}
