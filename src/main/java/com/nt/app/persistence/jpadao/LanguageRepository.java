package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
