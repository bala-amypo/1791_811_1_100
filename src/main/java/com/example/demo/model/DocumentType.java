package com.example.demo.model;

public class DocumentType {

    private String name;

    public DocumentType() {}

    public DocumentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Check if this document type is supported by a vendor
    public boolean isSupportedBy(Vendor vendor) {
        return vendor.getSupportedDocumentTypes().contains(this.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
