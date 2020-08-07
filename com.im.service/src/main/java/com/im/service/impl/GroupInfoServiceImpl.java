package com.im.service.impl;

import com.common.mongo.AbstractMongoService;
import com.im.domain.GroupInfo;
import com.im.domain.GroupUserRel;
import com.im.domain.model.GroupStatusEnum;
import com.im.domain.model.UserTypeEnum;
import com.im.service.GroupInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class GroupInfoServiceImpl extends AbstractMongoService<GroupInfo> implements GroupInfoService {

    @Override
    protected Class getEntityClass() {
        return GroupInfo.class;
    }

    @Override
    @Transactional
    public GroupInfo create(String pin, String proxyId, String title, String icon, String desc) {
        GroupInfo info = new GroupInfo();
        info.setIcon(icon);
        info.setDesc(desc);
        info.setSign(title);
        info.setGroupStatus(GroupStatusEnum.Normal);
        info.setProxyId(proxyId);
        insert(info);
        GroupUserRel userRel = new GroupUserRel();
        userRel.setGroupId(info.getId());
        userRel.setUserPin(pin);
        userRel.setUserType(UserTypeEnum.owner);
        primaryTemplate.insert(userRel);
        return info;
    }
}
