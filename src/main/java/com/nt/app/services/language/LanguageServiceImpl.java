package com.nt.app.services.language;

import com.nt.app.persistence.jpadao.LanguageRepository;
import com.nt.app.persistence.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language save(Language entity) {
        return languageRepository.save(entity);
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findOne(id);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        languageRepository.delete(id);
    }
}
