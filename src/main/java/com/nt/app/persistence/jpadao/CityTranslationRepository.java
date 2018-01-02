package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.city.CityTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityTranslationRepository extends JpaRepository<CityTranslation, Long> {

    List<CityTranslation> findByCityIdIn(List<Long> cityIds);

   /* @Query("select c from CityTranslation ct " +
            "inner JOIN ct.city c " +
            "ON ct.language.id = :languageId"
    )*/
    List<CityTranslation> findByLanguage_Id(@Param("language_id") Long language_id);
}

