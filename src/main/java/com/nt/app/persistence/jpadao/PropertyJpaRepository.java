package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyJpaRepository extends JpaRepository<Property, Long> {

    List<Property> findAll();
    Property findOne(Long id);
    Property save(Property property);
    void delete(Long id);
}
