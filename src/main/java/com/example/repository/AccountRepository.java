package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByUsername(String username);

    Account findAccountByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM account WHERE account_id=?1 ", nativeQuery = true)
    Account findAccountByAccount_id (int account_id);
}
