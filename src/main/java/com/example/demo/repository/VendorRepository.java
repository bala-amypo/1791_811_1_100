package com.example.demo.repository;

import com.example.demo.model.Vendor;

import java.util.Optional;

public interface VendorRepository {

    default Vendor save(Vendor vendor) {
        return vendor;
    }

    default Optional<Vendor> findById(Long id) {
        return Optional.empty();
    }
}
