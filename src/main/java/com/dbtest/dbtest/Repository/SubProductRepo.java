package com.dbtest.dbtest.Repository;


import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Entity.Subproduct;
import com.dbtest.dbtest.Entity.VendorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubProductRepo extends JpaRepository<Subproduct, Integer> {

    @Query
    Subproduct findBysubProductName(@Param("") String subProductName);

    @Query
    Subproduct findBysubProductId(@Param(" ") int subProductId);

    @Query
    Subproduct findBySubProductNameAndProductDetailsAndVendorDetails(@Param("") String subProductName, ProductEntity productDetails, VendorEntity vendorDetails );

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubProductRepo extends JpaRepository<Subproduct, Integer> {
   
    @Query
    Subproduct findBysubProductName(@Param("") String subProductName);


}
