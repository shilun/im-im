package com.im.socket.controller;

import com.im.socket.annotation.Controller;
import com.im.socket.annotation.MessageMapping;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Controller
@Component
@Slf4j
public class MessageController {
    @MessageMapping("/message/send")
    public void in(ChannelHandlerContext context) {
        log.warn("in");
    }
}
