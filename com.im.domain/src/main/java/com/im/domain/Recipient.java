package com.im.domain;

import com.im.domain.model.ContentTypeEnum;
import com.im.domain.model.RecipientTypeEnum;
import lombok.Data;

@Data
/**
 * 聊天接收者
 */
/**
 * 消息只存放于redis
 */
public class Recipient {
    /**
     * 内容
     */
    private String content;

    /**
     * 内容类型
     */
    private ContentTypeEnum contentType;

    /**
     * 接收者类型
     */
    private RecipientTypeEnum targetType;

    /**
     * 接收者
     */
    private String recipientPin;

}
