package com.nt.app.persistence.model.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nt.app.persistence.model.Language;
import com.nt.app.validators.uniquevalidator.Unique;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "city_translation")
public class CityTranslation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnoreProperties("translations")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    private City city;

    @Unique
    @NotNull
    private String title;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    private Language language;

    public CityTranslation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Long getModelId() {
        return city.getId();
   }

   public Long getLanguageId() {
        return language.getId();
   }
}
