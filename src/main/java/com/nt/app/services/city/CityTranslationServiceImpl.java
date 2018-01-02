package com.nt.app.services.city;

import com.nt.app.persistence.jpadao.CityTranslationRepository;
import com.nt.app.persistence.model.city.CityTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityTranslationService")
public class CityTranslationServiceImpl implements CityTranslationService {

    @Autowired
    private CityTranslationRepository cityTranslationRepository;

    @Override
    public List<CityTranslation> findByCityIdIn(List<Long> cityIds) {
        return cityTranslationRepository.findByCityIdIn(cityIds);
    }

    @Override
    public List<CityTranslation> findByLanguageId(Long languageId) {
        return cityTranslationRepository.findByLanguage_Id(languageId);
    }

    @Override
    public List<CityTranslation> save(List<CityTranslation> translations) {
        return cityTranslationRepository.save(translations);
    }

    @Override
    public CityTranslation save(CityTranslation entity) {
        return cityTranslationRepository.save(entity);
    }

    @Override
    public CityTranslation findById(Long id) {
        return null;
    }

    @Override
    public List<CityTranslation> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
