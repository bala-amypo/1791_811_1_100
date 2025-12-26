package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private boolean verified;

    // REQUIRED by test
    public void setId(Long id) {
        this.id = id;
    }

    // REQUIRED by test
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    // REQUIRED by test
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    // REQUIRED by test
    public boolean isVerified() {
        return verified;
    }
}
