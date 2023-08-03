package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.Set;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

      @Query
      ProductEntity findByproductName(@Param("") String productName);
      @Query
      ProductEntity findByproductId (@Param(" ") int productId);


  //  @Modifying
    //@Transactional
    //@Query("update ProductEntity p set p.productName = :newProductName, p.lastupdatedby = :lastupdatedby, p.lastupdatedtimestamp = :lastupdatedtimestamp where p.productName = :existingProduct")
    //ProductEntity updateProductName(String existingProduct, String newProductName, String lastupdatedby, LocalDateTime lastupdatedtimestamp);

//      @Modifying
//      @Transactional
//      @Query("update ProductEntity p set p.productname = :productname  where p.productId=:productId")
//      void updateProductName(String productname);
//@Modifying
//@Transactional
//      @Query("UPDATE ProductEntity p SET p.productName = :productName WHERE productId = :productId")
//      void updateProductName( String productName, Integer productId);



}
