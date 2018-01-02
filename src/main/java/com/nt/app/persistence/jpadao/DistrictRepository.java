package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long>{
}
