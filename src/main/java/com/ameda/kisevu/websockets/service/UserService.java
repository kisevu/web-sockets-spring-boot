package com.ameda.kisevu.websockets.service;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.service
*
*/

import com.ameda.kisevu.websockets.entity.Status;
import com.ameda.kisevu.websockets.entity.User;
import com.ameda.kisevu.websockets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnect(User user){
      var storedUser = userRepository.findById(user.getNickName())
               .orElseThrow(null);
      if(storedUser != null){
          storedUser.setStatus(Status.OFFLINE);
          userRepository.save(storedUser);
      }
    }

    public List<User> findConnectedUsers(){
        return userRepository.findAllByStatus(Status.ONLINE);
    }

}
