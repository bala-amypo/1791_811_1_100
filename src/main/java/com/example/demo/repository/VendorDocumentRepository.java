package com.example.demo.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;
import com.example.demo.model.*;
public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {
    List<VendorDocument> findByVendor(Vendor vendor);
     @Query("SELECT v FROM VendorDocument v WHERE v.expiryDate < :date")
    List<VendorDocument> findExpiredDocuments(@Param("date") LocalDate date);
}