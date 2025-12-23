package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentType;
    private LocalDate expiryDate;
    private boolean isValid;

    @ManyToOne
    private Vendor vendor;

    // getters & setters
}
