package com.ameda.kisevu.websockets.repository;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.repository
*
*/

import com.ameda.kisevu.websockets.entity.Status;
import com.ameda.kisevu.websockets.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    List<User> findAllByStatus(Status status);
}
