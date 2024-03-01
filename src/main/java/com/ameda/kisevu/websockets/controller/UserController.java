package com.ameda.kisevu.websockets.controller;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.controller
*
*/

import com.ameda.kisevu.websockets.entity.User;
import com.ameda.kisevu.websockets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MessageMapping("/user.addUser") //notify all users and send message to websockets
     //inform all connected users of new user and 'topic' as new queue which automatically is created...
    @SendTo("/user/topic")
    public User addUser(@Payload User user){
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public User disconnect(@Payload User user){
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> disconnectedUsers(){
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
