package com.nt.app.persistence.model;

import com.nt.app.validators.uniquevalidator.Unique;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Street {

    @Id
    @GeneratedValue
    private Long id;

    @Unique
    @NotEmpty
    @NotNull
    private String name;

    private Long cityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
