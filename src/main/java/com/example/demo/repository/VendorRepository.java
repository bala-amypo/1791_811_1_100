package com.example.demo.repository;

import com.example.demo.entity.Vendor;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepository {

    public Vendor findById(Long id) {
        return new Vendor(id, "Demo Vendor");
    }
}
