package com.example.controller;

import com.example.entity.Account;
import com.example.service.AccountService;
import com.example.entity.Message;
import com.example.service.MessageService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

@RestController
public class SocialMediaController {

    @Autowired
    AccountService accountService;

    @Autowired
    MessageService messageService;

    // //// ACCOUNTS //////////////////////////////

    // **** Create ********

    @PostMapping("register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account newAccount) {
        // Validate username not empty and password at least 4 characters in length
        if ((newAccount.getUsername() == null) || (newAccount.getPassword() == null)) {
            return ResponseEntity.status(400).body(null);
        }
        if ( (newAccount.getUsername().length() < 1) || 
                (newAccount.getPassword().length() < 4)) {
            return ResponseEntity.status(400).body(null);
        }

        // validate unique username
        if (accountService.accountExists(newAccount.getUsername())) {
            return ResponseEntity.status(409).body(newAccount);
        }

        // Add new account to database
        Account registeredAccount = accountService.insertAccount(newAccount);
        return ResponseEntity.status(200).body(registeredAccount);
    }

    // **** Retrieve ********

    @GetMapping("accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> allAccounts = accountService.getAllAccounts();
        return ResponseEntity.status(200).body(allAccounts);
    }

    @PostMapping("login")
    public ResponseEntity<Account> loginAccount(@RequestBody Account targetAccount) {
        Account loggedAccount = accountService.getAccountByUsernameAndPassword(targetAccount.getUsername(), targetAccount.getPassword());

        if (loggedAccount != null) {
            return ResponseEntity.status(200).body(loggedAccount);

        }
        return ResponseEntity.status(401).body(targetAccount);
    }

    // //// MESSAGES //////////////////////////////

    // **** Create ********
    // **** Rewtrieve ********

    @GetMapping("messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> allMessages = messageService.getAllMessages();
        return ResponseEntity.status(200).body(allMessages);
    }

    @GetMapping("messages/{id}")
    public ResponseEntity<Message> getMessageByID (@PathVariable String id) {
        int messageId = Integer.parseInt(id);
        Message retrievedMessage = messageService.getMessageByID(messageId);
        return ResponseEntity.status(200).body(retrievedMessage);
    }

    // **** Update ********
    // **** Delete ********


}
