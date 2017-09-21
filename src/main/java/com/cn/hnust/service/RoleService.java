package com.cn.hnust.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cn.hnust.domain.URole;

public interface RoleService {

	int deleteByPrimaryKey(Long id);

	int insert(URole record);

	int insertSelective(URole record);

	URole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(URole record);

	int updateByPrimaryKey(URole record);

	Map<String, Object> deleteRoleById(String ids);

	Set<String> findRoleByUserId(Long userId);

	List<URole> findNowAllPermission();

	void initData();

	List<URole> selectAll();

}
