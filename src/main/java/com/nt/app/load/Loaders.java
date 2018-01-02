/*
package com.nt.app.load;

import com.nt.app.persistence.elastic.PropertyRepository;
import com.nt.app.persistence.jpadao.PropertyJpaRepository;
import com.nt.app.persistence.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    PropertyJpaRepository propertyJpaRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @PostConstruct
    @Transactional
    public void loadAll() {
        System.out.println("mapping");
        elasticsearchOperations.getMapping(Property.class);
        propertyJpaRepository.save(getData());
        propertyRepository.save(propertyJpaRepository.findAll());
        System.out.println("done");
    }

    private List<Property> getData() {
        List<Property> properties = new ArrayList<>();
        Property property1 = new Property();
        property1.setAddress("g");

        Property property2 = new Property();
        property2.setAddress("g");

        Property property3 = new Property();
        property3.setAddress("jjjjj");

        Property property4 = new Property();
        property4.setAddress("g");

        properties.addAll(Arrays.asList(property1, property2, property3, property4));

        return properties;
    }
}
*/
