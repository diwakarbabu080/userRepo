package com.divakar.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Address.java
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Address {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;

    @Embedded
    private Coordinates coordinates;

    private String country;
}