package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    // **** Create ********

    // **** Retrieve ********

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageByID(int targetMessageID) {
        return messageRepository.findMessageByMessage_id(targetMessageID);
    }

    // **** Update ********

    // **** Delete ********


}
