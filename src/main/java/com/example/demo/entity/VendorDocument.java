package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;

    private LocalDate expiryDate;

    private Boolean isValid;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;
}
