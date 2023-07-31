package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.Subproduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubProductRepo extends JpaRepository<Subproduct, Integer> {
}
