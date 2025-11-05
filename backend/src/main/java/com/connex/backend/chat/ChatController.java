package com.connex.backend.chat;

import com.connex.backend.chat.model.Message;
import com.connex.backend.chat.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class ChatController {
    private final SimpMessagingTemplate template;
    private final MessageRepository repository;

    public ChatController(SimpMessagingTemplate template, MessageRepository repository) {
        this.template = template;
        this.repository = repository;
    }

    @MessageMapping("/chat.send/{channelId}")
    public void sendMessage(@DestinationVariable String channelId, @Payload Message incoming) {
        // basic persistence
        incoming.setChannelId(channelId);
        incoming.setCreatedAt(Instant.now());
        Message saved = repository.save(incoming);
        template.convertAndSend("/topic/channel/" + channelId, saved);
    }
}
