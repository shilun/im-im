package com.im.domain;

import com.common.util.AbstractBaseEntity;
import com.common.util.AbstractSeqIdEntity;
import com.im.domain.model.ContentTypeEnum;
import com.im.domain.model.RecipientTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
/**
 * 消息只存放于redis
 * 当单聊时消息接收确认时直接清楚
 * 对于群聊保留1周数据
 */
public  class MessageInfo extends AbstractBaseEntity implements AbstractSeqIdEntity {
    /**
     * 发送者
     */
    private String senderPin;

    /**
     * 代理
     */
    private String proxyId;
    /**
     * 内容
     */
    private String content;

    /**
     * 内容类型
     */
    private ContentTypeEnum contentType;
    /**
     * 接收者类型 用户/组
     */
    private RecipientTypeEnum recipientType;
    /**
     * 接收者 用户pin/组id
     */
    private String recipientId;


}
