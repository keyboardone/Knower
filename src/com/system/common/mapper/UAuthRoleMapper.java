package com.system.common.mapper;

import com.system.common.entity.UAuthRole;

public interface UAuthRoleMapper {
    int insert(UAuthRole record);

    int insertSelective(UAuthRole record);
}