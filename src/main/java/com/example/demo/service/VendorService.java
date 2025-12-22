package com.example.demo.service;

import com.example.demo.entity.Vendor;
import java.util.List;
import java.util.Optional;

public interface VendorService {
    List<Vendor> getAllVendors();
    Optional<Vendor> getVendorById(Long id);
    Vendor saveVendor(Vendor vendor);
    void deleteVendor(Long id);
}
