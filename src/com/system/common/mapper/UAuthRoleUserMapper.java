package com.system.common.mapper;

import com.system.common.entity.UAuthRoleUser;

public interface UAuthRoleUserMapper {
    int insert(UAuthRoleUser record);

    int insertSelective(UAuthRoleUser record);
}