package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SignupRepo extends JpaRepository<User, Integer> {

    @Query
    User findByemailId(@Param("emailId") String emailId);
}
