package com.nt.app.controllers.dashboard;

import com.nt.app.persistence.model.Language;
import com.nt.app.services.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/language")
@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public List<Language> index() {
        return languageService.findAll();
    }
}
