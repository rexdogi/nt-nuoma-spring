package com.nt.app.controllers.dashboard;

import com.nt.app.persistence.model.Language;
import com.nt.app.persistence.model.city.City;
import com.nt.app.persistence.model.city.CityDTO;
import com.nt.app.persistence.model.city.CityTranslation;
import com.nt.app.services.city.CityServiceImpl;
import com.nt.app.services.city.CityTranslationServiceImpl;
import com.nt.app.services.language.LanguageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private CityTranslationServiceImpl cityTranslationService;

    @Autowired
    private LanguageServiceImpl languageService;

    @Autowired
    private ModelMapper modelMapper;

  /*  @GetMapping
    public HashMap<String, Object> index() {
        List<City> cities = cityService.findAll();
        List<Long> cityIds = cities.stream().map(City::getId).collect(Collectors.toList());
        List<CityTranslation>  translations = cityTranslationService.findByCityIdIn(cityIds);
        HashMap<String, Object> result = new HashMap<>();
        result.put("cities", cities);
        result.put("translations", translations);
        return result;
    }*/

    @GetMapping
    public List<CityDTO> index(@RequestParam Long languageId) {
        List<CityTranslation> cityTranslations = cityTranslationService.findByLanguageId(languageId);

        return cityTranslations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<City> store(@Valid @RequestBody City city) {
        cityService.save(city);
        city.getTranslations().forEach(t -> t.setCity(city));
        cityTranslationService.save(city.getTranslations());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> edit(@PathVariable Long id) {
        City city = cityService.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<City> update(@Valid @RequestBody City city) {
        if(city != null) {
            cityService.save(city);
            city.getTranslations().forEach(t -> t.setCity(city));
            cityTranslationService.save(city.getTranslations());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<City> update(@PathVariable Long id) {
        City city = cityService.findById(id);
        if(city != null) {
            cityService.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private CityDTO convertToDto(CityTranslation cityTranslation) {
        CityDTO cityDTO = modelMapper.map(cityTranslation, CityDTO.class);
        cityDTO.setId(cityTranslation.getCity().getId());
        cityDTO.setTitle(cityTranslation.getTitle());
        return cityDTO;
    }

    private City convertToEntity(CityDTO cityDTO) {
        City city = modelMapper.map(cityDTO, City.class);
        return city;
    }

}
