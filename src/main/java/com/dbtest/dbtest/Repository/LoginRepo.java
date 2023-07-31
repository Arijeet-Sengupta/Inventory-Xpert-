package com.dbtest.dbtest.Repository;

import com.dbtest.dbtest.Entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface LoginRepo extends JpaRepository<Account, Integer> {
      @Query
     Account findByEmail(@Param("Email") String email);

      @Transactional
      @Modifying
      @Query(("update Account acc set acc.last_login = ?1 where acc.email = ?2"))
      void updateLastLogin(@Param(" ") LocalDateTime last_login, String email);
}
