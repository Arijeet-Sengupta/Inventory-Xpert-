package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.User;
import com.dbtest.dbtest.Entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VendorRepo extends JpaRepository<VendorEntity, Integer>{



    @Query
    VendorEntity findByvendorName(@Param("") String vendorName);
    @Query
    VendorEntity findByVendorid(@Param("") int vendorid);
    @Query
    VendorEntity findByVendorNameAndVendorLocationAndEmail(@Param("") String vendorName,String vendorlocation,String email);

}