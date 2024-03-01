package com.ameda.kisevu.websockets.repository;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.repository
*
*/

import com.ameda.kisevu.websockets.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage,String> {
    List<ChatMessage> findByChatId(String s);
}
