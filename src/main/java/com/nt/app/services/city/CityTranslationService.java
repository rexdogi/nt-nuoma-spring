package com.nt.app.services.city;

import com.nt.app.persistence.model.city.CityTranslation;
import com.nt.app.services.CrudService;

import java.util.List;

public interface CityTranslationService extends CrudService<CityTranslation> {

    List<CityTranslation> findByCityIdIn(List<Long> cityIds);

    List<CityTranslation> findByLanguageId(Long languageId);

    List<CityTranslation> save(List<CityTranslation> translations);
}

