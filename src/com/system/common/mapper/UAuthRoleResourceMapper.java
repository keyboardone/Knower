package com.system.common.mapper;

import com.system.common.entity.UAuthRoleResource;

public interface UAuthRoleResourceMapper {
    int insert(UAuthRoleResource record);

    int insertSelective(UAuthRoleResource record);
}