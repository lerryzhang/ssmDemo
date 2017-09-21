package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import com.cn.hnust.domain.URole;

public interface UUserRoleDao {
	int insert(URole record);

	int insertSelective(URole record);

	int deleteByUserId(Long id);

	int deleteRoleByUserIds(Map<String, Object> resultMap);

	List<Long> findUserIdByRoleId(Long id);
}