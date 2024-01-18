package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.transaction.Transactional;

public interface MessageRepository extends JpaRepository<Message, Long> {

    // **** Retrieve ********

    @Query(value = "SELECT * FROM message WHERE message_id=?1", nativeQuery = true)
    Message findMessageByMessage_id(int message_id);

    @Query(value = "SELECT * FROM message WHERE posted_by=?1", nativeQuery = true)
    List<Message> findMessagesByPosted_by(int posted_by);

    // **** Delete *********

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM message WHERE message_id=?1", nativeQuery = true)
    int deleteMessageByMessage_id(int message_id);
}
