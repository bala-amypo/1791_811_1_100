package com.example.demo.model;

public class Vendor {

    private Long id;
    private String name;
    private boolean compliant;

    public Vendor() {}

    public Vendor(Long id, String name, boolean compliant) {
        this.id = id;
        this.name = name;
        this.compliant = compliant;
    }

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

    public boolean isCompliant() {
        return compliant;
    }

    public void setCompliant(boolean compliant) {
        this.compliant = compliant;
    }
}
