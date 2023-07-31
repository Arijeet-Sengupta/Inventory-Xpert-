package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {


    @Query
    ProductEntity findByproductName (@Param(" ") String productName);
}
