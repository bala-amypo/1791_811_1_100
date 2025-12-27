package com.example.demo.model;

import java.util.Date;

public class VendorDocument {
    private Long id;
    private Date expiryDate;
    private boolean isValid;

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public boolean isValid() { return isValid; }
    public void setIsValid(boolean isValid) { this.isValid = isValid; }

    // other getters/setters
}
