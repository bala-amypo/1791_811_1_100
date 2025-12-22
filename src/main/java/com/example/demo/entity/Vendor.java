package com.example.demo.entity;

public class Vendor {

    private Long id;
    private String vendorName;

    public Vendor() {}

    public Vendor(Long id, String vendorName) {
        this.id = id;
        this.vendorName = vendorName;
    }

    public Long getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
