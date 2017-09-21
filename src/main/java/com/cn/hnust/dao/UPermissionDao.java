package com.cn.hnust.dao;

import java.util.List;
import java.util.Set;

import com.cn.hnust.domain.UPermission;

public interface UPermissionDao {
	int deleteByPrimaryKey(Long id);

	int insert(UPermission record);

	int insertSelective(UPermission record);

	UPermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UPermission record);

	int updateByPrimaryKey(UPermission record);

	Set<String> findPermissionByUserId(Long id);

	public List<UPermission> findAllPermission();

}