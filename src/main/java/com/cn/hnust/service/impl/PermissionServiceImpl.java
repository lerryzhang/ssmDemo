package com.cn.hnust.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.UPermissionDao;
import com.cn.hnust.dao.URolePermissionDao;
import com.cn.hnust.dao.UUserRoleDao;
import com.cn.hnust.dao.UserDao;
import com.cn.hnust.domain.PermissionAllRole;
import com.cn.hnust.domain.UPermission;
import com.cn.hnust.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	UPermissionDao permissionDao;
	@Autowired
	UserDao userDao;
	@Autowired
	URolePermissionDao rolePermissionDao;

	@Autowired
	UUserRoleDao userRoleDao;

	public int deleteByPrimaryKey(Long id) {
		return permissionDao.deleteByPrimaryKey(id);
	}

	public UPermission insert(UPermission record) {
		permissionDao.insert(record);
		return record;
	}

	public UPermission insertSelective(UPermission record) {
		// 添加权限
		permissionDao.insertSelective(record);
		// 每添加一个权限，都往【系统管理员 888888】里添加一次。保证系统管理员有最大的权限

		return record;
	}

	public UPermission selectByPrimaryKey(Long id) {
		return permissionDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(UPermission record) {
		return permissionDao.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(UPermission record) {
		return permissionDao.updateByPrimaryKeySelective(record);
	}

	public Map<String, Object> addPermission2Role(Long roleId, String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> deleteByRids(String roleIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> deletePermissionById(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findPermissionByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UPermission> findAllPermission() {
		// TODO Auto-generated method stub
		return permissionDao.findAllPermission();
	}

	public List<PermissionAllRole> findRoleAndPermission() {
		// TODO Auto-generated method stub
		return rolePermissionDao.findRoleAndPermission();
	}

}
