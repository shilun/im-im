package com.im.domain.model;

import com.common.util.IGlossary;

/**
 * 组状态
 */
public enum GroupStatusEnum implements IGlossary {

    Normal("正常"),
    SpeakingNot("禁言"),


    ;
    private String name;

    GroupStatusEnum(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }
}
