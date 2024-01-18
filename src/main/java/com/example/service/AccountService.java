package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    // **** Create ********

    public Account insertAccount(Account newAccount) {
        return accountRepository.save(newAccount);
    }

    // **** Retrieve ********

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public boolean accountExists(String targetUsername) {
        if (accountRepository.findAccountByUsername(targetUsername) != null) {
            return true;
        }
        return false;
    }

    public boolean accountExists(int id) {
        if ( accountRepository.findAccountByAccount_id(id) != null ) {
            return true;
        }
        return false;
    }

    public Account getAccountByUsernameAndPassword (String targetUsername, String targetPassword) {
        return accountRepository.findAccountByUsernameAndPassword(targetUsername, targetPassword);
    }

}
