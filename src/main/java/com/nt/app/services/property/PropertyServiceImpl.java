package com.nt.app.services.property;

import com.nt.app.persistence.jpadao.PropertyJpaRepository;
import com.nt.app.persistence.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyJpaRepository propertyRepository;

    @Override
    public Property save(Property entity) {
       return propertyRepository.save(entity);
    }

    @Override
    public Property findById(Long id) {
        return  propertyRepository.findOne(id);
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        propertyRepository.delete(id);
    }
}
