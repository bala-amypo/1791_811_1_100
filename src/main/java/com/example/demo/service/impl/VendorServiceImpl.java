package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Override
    public List<Vendor> getAllVendors() {
        return List.of(
                new Vendor(1L, "Vendor A"),
                new Vendor(2L, "Vendor B")
        );
    }
}
