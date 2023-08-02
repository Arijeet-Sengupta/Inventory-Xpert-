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
    VendorEntity findByVendorName(@Param("") String vendorName);
//    @Query
//    VendorEntity findByVendord(@Param("") int vendorid);
//   @Transactional
//   @Modifying
//   @Query
//   VendorEntity updatevendorName(@Param("vendorname") String vendorName);

}