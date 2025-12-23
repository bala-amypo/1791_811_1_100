package com.example.demo.serviceimpl;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    public VendorServiceImpl(VendorRepository repository) {
        this.repository = repository;
    }

    public Vendor save(Vendor vendor) {
        return repository.save(vendor);
    }

    public Vendor getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Vendor> getAll() {
        return repository.findAll();
    }

    public Vendor update(Long id, Vendor vendor) {
        vendor.setId(id);
        return repository.save(vendor);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
