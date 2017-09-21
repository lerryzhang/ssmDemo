package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cn.hnust.domain.URole;

public interface URoleDao {
	int deleteByPrimaryKey(Long id);

	int insert(URole record);

	int insertSelective(URole record);

	URole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(URole record);

	int updateByPrimaryKey(URole record);

	Set<String> findRoleByUserId(Long id);

	List<URole> findNowAllPermission(Map<String, Object> map);

	void initData();

	List<URole> selectAll();
}