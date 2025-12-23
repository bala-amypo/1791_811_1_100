package com.example.demo.service;

import com.example.demo.entity.Vendor;
import java.util.List;

public interface VendorService {

    Vendor save(Vendor vendor);
    Vendor getById(Long id);
    List<Vendor> getAll();
    Vendor update(Long id, Vendor vendor);
    void delete(Long id);
}
