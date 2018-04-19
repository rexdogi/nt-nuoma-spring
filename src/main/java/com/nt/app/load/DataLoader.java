package com.nt.app.load;

import com.nt.app.persistence.model.Language;
import com.nt.app.services.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private LanguageService languageService;

    @Override
    public void run(ApplicationArguments args) {
        try {
            Language en = new Language();
            Language lt = new Language();
            en.setCode("en");
            en.setTitle("English");
            lt.setCode("lt");
            lt.setTitle("Lithuanian");
            languageService.save(en);
            languageService.save(lt);
        } catch (Exception e) {}
    }
}
