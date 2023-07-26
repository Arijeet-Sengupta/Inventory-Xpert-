package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoginRepo extends JpaRepository<login, Integer> {
    @Query
    login findByUsername(@Param("username") String username);
}
