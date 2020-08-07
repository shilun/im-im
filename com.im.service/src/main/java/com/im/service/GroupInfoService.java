package com.im.service;

import com.common.mongo.MongoService;
import com.im.domain.GroupInfo;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

/**
 * 组服务接口
 */
@Validated(Default.class)
public interface GroupInfoService extends MongoService<GroupInfo> {
    GroupInfo create(@NotEmpty String pin,@NotEmpty String proxyId, @NotEmpty String title, String icon, String desc);
}
