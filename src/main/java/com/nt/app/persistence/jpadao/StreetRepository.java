package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
