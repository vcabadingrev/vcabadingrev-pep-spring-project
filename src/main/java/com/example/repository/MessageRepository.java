package com.example.repository;

import com.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

//     @Query(value = "SELECT * FROM municipalperson WHERE municipal_id=?1 ORDER BY last_name DESC", nativeQuery = true)
// List<Municipalperson> findByMunicipal_idOrderByLastnameDesc(int municipal_id);

@Query(value = "SELECT * FROM message WHERE message_id=?1", nativeQuery = true)
Message findMessageByMessage_id(int message_id);

}
