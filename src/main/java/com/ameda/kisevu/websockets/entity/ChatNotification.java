package com.ameda.kisevu.websockets.entity;/*
*
@author ameda
@project web-sockets
@package com.ameda.kisevu.websockets.entity
*
*/

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
    private String id;
    private String senderId;
    private String recipientId;
    private String content;
}
