package com.nt.app.persistence.dao;

import com.nt.app.persistence.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {


}
