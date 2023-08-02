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
      ProductEntity findByproductname(@Param("") String productname);
    @Query
    ProductEntity findByproductid (@Param(" ") int productid);


  //  @Modifying
    //@Transactional
    //@Query("update ProductEntity p set p.productName = :newProductName, p.lastupdatedby = :lastupdatedby, p.lastupdatedtimestamp = :lastupdatedtimestamp where p.productName = :existingProduct")
    //ProductEntity updateProductName(String existingProduct, String newProductName, String lastupdatedby, LocalDateTime lastupdatedtimestamp);





}
