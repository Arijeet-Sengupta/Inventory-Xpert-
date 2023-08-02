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
      ProductEntity findByproductName(@Param("") String productname);
    @Query
    ProductEntity findByproductId (@Param(" ") int productid);









}
