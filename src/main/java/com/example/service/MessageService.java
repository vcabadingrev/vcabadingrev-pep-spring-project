package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    // **** Create ********

    // **** Retrieve ********

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // **** Update ********

    // **** Delete ********


}
