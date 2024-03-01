package com.ameda.kisevu.websockets.entity;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.entity
*
*/

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class User {
    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
