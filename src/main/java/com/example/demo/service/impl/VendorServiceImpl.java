package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    @Override
    public Vendor getVendor(Long id) {
        return new Vendor(id, "Test Vendor", true);
    }
}
