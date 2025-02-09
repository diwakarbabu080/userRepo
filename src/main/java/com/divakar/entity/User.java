package com.divakar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String maidenName;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;

//    @JsonProperty("birthDate")
    private String birthDate;


    private String image;
    private String bloodGroup;
    private Double height;
    private Double weight;
    private String eyeColor;

    @Embedded
    private Hair hair;

    private String ip;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "home_address")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "stateCode", column = @Column(name = "home_state_code")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "home_postal_code")),
            @AttributeOverride(name = "coordinates.lat", column = @Column(name = "home_latitude")),
            @AttributeOverride(name = "coordinates.lng", column = @Column(name = "home_longitude")),
            @AttributeOverride(name = "country", column = @Column(name = "home_country"))
    })
    private Address address;

    private String macAddress;
    private String university;

    @Embedded
    private Bank bank;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "department", column = @Column(name = "company_department")),
            @AttributeOverride(name = "name", column = @Column(name = "company_name")),
            @AttributeOverride(name = "title", column = @Column(name = "company_title")),
            @AttributeOverride(name = "address.address", column = @Column(name = "company_address")),
            @AttributeOverride(name = "address.city", column = @Column(name = "company_city")),
            @AttributeOverride(name = "address.state", column = @Column(name = "company_state")),
            @AttributeOverride(name = "address.stateCode", column = @Column(name = "company_state_code")),
            @AttributeOverride(name = "address.postalCode", column = @Column(name = "company_postal_code")),
            @AttributeOverride(name = "address.coordinates.lat", column = @Column(name = "company_latitude")),
            @AttributeOverride(name = "address.coordinates.lng", column = @Column(name = "company_longitude")),
            @AttributeOverride(name = "address.country", column = @Column(name = "company_country"))
    })
    private Company company;

    private String ein;
    private String ssn;
    private String userAgent;

    @Embedded
    private Crypto crypto;

    private String role;


    // Getters and setters

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate='" + birthDate + '\'' +

                '}';
    }

}
