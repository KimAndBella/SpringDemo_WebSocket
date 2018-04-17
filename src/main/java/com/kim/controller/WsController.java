package com.kim.controller;

import com.kim.message.RequestMessage;
import com.kim.message.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by admin on 2018/4/18.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse") //@SendTo注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息
    public ResponseMessage say(RequestMessage requestMessage){
        System.out.println("Wscontroller say = "+requestMessage.getName());
        return new ResponseMessage("welcome "+requestMessage.getName()+"  ~~~~");
    }
}
