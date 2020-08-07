package com.im.service;

import com.common.mongo.MongoService;
import com.im.domain.MessageInfo;
import com.im.domain.model.ContentTypeEnum;
import com.im.domain.model.RecipientTypeEnum;

/**
 * 消息发送
 */
public interface MessageInfoService extends MongoService<MessageInfo> {
    /**
     * 消息发的送
     * @param proxyId
     * @param senderPin
     * @param content
     * @param contentType
     * @param recipientType
     * @param recipientId
     */
    void send(String proxyId, String senderPin, String content, ContentTypeEnum contentType, RecipientTypeEnum recipientType, String recipientId);

    /**
     * 消息回撤
     * @param proxyId
     * @param senderPin
     * @param msgId
     * @param recipientType
     */
    void unSend(String proxyId,String senderPin,String msgId,RecipientTypeEnum recipientType);
}
