package com.nt.app.controllers.dashboard;

import com.nt.app.persistence.model.Property;
import com.nt.app.services.property.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;

    @GetMapping
    public List<Property> index() {
        return propertyService.findAll();
    }

    @PostMapping
    public ResponseEntity<Property> store(@Valid @RequestBody Property property) {
        propertyService.save(property);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public Property edit(@PathVariable Long id) {
        return propertyService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Property> update(@Valid @RequestBody Property property) {
        if(property != null) {
            propertyService.save(property);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Property> update(@PathVariable Long id) {
        Property property = propertyService.findById(id);
        if(property != null) {
            propertyService.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
