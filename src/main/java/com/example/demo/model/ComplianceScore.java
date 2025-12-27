package com.example.demo.model;

public class ComplianceScore {
    private Vendor vendor;
    private double score;
    private String rating;

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
}
