package com.ameda.kisevu.websockets.repository;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.repository
*
*/

import com.ameda.kisevu.websockets.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom,String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
