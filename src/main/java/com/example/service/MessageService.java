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

    public Message insertMessage (Message newMessage) {
        return messageRepository.save(newMessage);
    }

    // **** Retrieve ********

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageByID(int targetMessageID) {
        return messageRepository.findMessageByMessage_id(targetMessageID);
    }

    public List<Message> getMessagesByAccountID(int accountID) {
        return messageRepository.findMessagesByPosted_by(accountID);
    }

    // **** Update ********

    public Message updateMessage(Message newMessage) {
        Message messageToUpdate = messageRepository.findMessageByMessage_id(newMessage.getMessage_id());
        
        // Check if message to update was not found in database
        if (messageToUpdate == null) {
            return null;
        }

        // Check validity of new message text
        if (newMessage.getMessage_text() == null) {
            return null;
        }
        if ((newMessage.getMessage_text().length()<1) || (newMessage.getMessage_text().length()>255)) {
            return null;
        }

        // Update new message text
        messageToUpdate.setMessage_text(newMessage.getMessage_text());

        // Update message in the database
        return messageRepository.save(messageToUpdate);
    }

    // **** Delete ********

    public int deleteMessage (int targetMessageID) {
        return messageRepository.deleteMessageByMessage_id(targetMessageID);
    }
}
