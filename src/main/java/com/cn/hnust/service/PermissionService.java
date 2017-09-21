package com.cn.hnust.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cn.hnust.domain.PermissionAllRole;
import com.cn.hnust.domain.UPermission;

public interface PermissionService {

	int deleteByPrimaryKey(Long id);

	UPermission insert(UPermission record);

	UPermission insertSelective(UPermission record);

	UPermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UPermission record);

	int updateByPrimaryKey(UPermission record);

	Map<String, Object> deletePermissionById(String ids);

	Map<String, Object> addPermission2Role(Long roleId, String ids);

	Map<String, Object> deleteByRids(String roleIds);

	Set<String> findPermissionByUserId(Long userId);

	public List<UPermission> findAllPermission();

	List<PermissionAllRole> findRoleAndPermission();
}
