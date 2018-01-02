package com.nt.app.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Rent {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private double lat;
    private double lng;

    private double price;
}
