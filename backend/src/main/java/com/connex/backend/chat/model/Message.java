package com.connex.backend.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "messages")
public class Message {
    @Id
    private String id;

    private String channelId;
    private Long senderUserId;
    private String senderUsername;
    private String content;
    private Instant createdAt;

    public Message(){}

    // getters / setters
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getChannelId(){return channelId;}
    public void setChannelId(String channelId){this.channelId = channelId;}
    public Long getSenderUserId(){return senderUserId;}
    public void setSenderUserId(Long senderUserId){this.senderUserId = senderUserId;}
    public String getSenderUsername(){return senderUsername;}
    public void setSenderUsername(String senderUsername){this.senderUsername = senderUsername;}
    public String getContent(){return content;}
    public void setContent(String content){this.content = content;}
    public Instant getCreatedAt(){return createdAt;}
    public void setCreatedAt(Instant createdAt){this.createdAt = createdAt;}
}
