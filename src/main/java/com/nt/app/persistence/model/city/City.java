package com.nt.app.persistence.model.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Valid
    @JsonIgnoreProperties("city")
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<CityTranslation> translations;

    private double lat;

    private double lng;

    private Long countryId;

    public City() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CityTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<CityTranslation> translations) {
        this.translations = translations;
    }

}
