package com.divakar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/// Company.java
//@Embeddable
//public class Company {
//    private String department;
//    private String name;
//    private String title;

    // Company.java
    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    public class Company {
        private String department;
        private String name;
        private String title;

        @Embedded
        private Address address;
    }



