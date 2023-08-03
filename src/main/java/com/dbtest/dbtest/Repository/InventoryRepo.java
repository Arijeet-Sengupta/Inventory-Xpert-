package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.Inventory;
import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Entity.Subproduct;
import com.dbtest.dbtest.Entity.VendorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
     @Query
    Inventory findByinventoryid(@Param(" ") int inventoryid);


     @Query
     Inventory findByProductDetailsAndSubProductDetailsAndVendorDetails(ProductEntity productId, Subproduct subProductId, VendorEntity vendorId);


}
