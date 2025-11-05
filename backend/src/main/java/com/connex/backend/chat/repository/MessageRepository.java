package com.connex.backend.chat.repository;

import com.connex.backend.chat.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByChannelIdOrderByCreatedAtAsc(String channelId);
}
