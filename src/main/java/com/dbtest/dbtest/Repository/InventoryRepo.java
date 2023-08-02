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
    Inventory findBysubProductDetails(@Param(" ") Subproduct productEntity);


     @Query
     Inventory findByProductDetailsAndSubProductDetailsAndVendorDetails(ProductEntity productId, Subproduct subProductId, VendorEntity vendorId);

    @Transactional
    @Modifying
    @Query(("update Inventory inventory set inventory.quantity = ?1 where inventory.subProductDetails = ?2"))
    void updatequantity(@Param(" ") int quantity, Subproduct subProductDetails);

    @Transactional
    @Modifying
    @Query(("update Inventory inventory set inventory.stocklocation = ?1 where inventory.subProductDetails = ?2"))
    void updatestocklocation(@Param(" ") String stocklocation, Subproduct subProductDetails);

    @Transactional
    @Modifying
    @Query(("update Inventory inventory set inventory.lastUpdatedTimestamp = ?1 where inventory.subProductDetails = ?2"))
    void updatelastUpdatedTimestamp(@Param(" ") LocalDateTime lastUpdatedTimestamp, Subproduct subProductDetails);

    @Transactional
    @Modifying
    @Query(("update Inventory inventory set inventory.lastUpdatedBy = ?1 where inventory.subProductDetails = ?2"))
    void updatelastUpdatedBy(@Param(" ") String lastUpdatedBy, Subproduct subProductDetails);

    @Transactional
    @Modifying
    @Query(("update Inventory inventory set inventory.productPurchasePrice = ?1 where inventory.subProductDetails = ?2"))
    void updateproductPurchasePrice(@Param(" ") Double productPurchasePrice, Subproduct subProductDetails);

    @Transactional
    @Modifying
    @Query(("update Inventory inventory set inventory.productSellingPrice = ?1 where inventory.subProductDetails = ?2"))
    void updateproductSellingPrice(@Param(" ") Double productSellingPrice, Subproduct subProductDetails);
}
