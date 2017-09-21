package com.cn.hnust.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.URoleDao;
import com.cn.hnust.dao.URolePermissionDao;
import com.cn.hnust.dao.UserDao;
import com.cn.hnust.domain.URole;
import com.cn.hnust.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	URoleDao roleDao;
	@Autowired
	UserDao userDao;
	@Autowired
	URolePermissionDao rolePermissionDao;

	public int deleteByPrimaryKey(Long id) {
		return roleDao.deleteByPrimaryKey(id);
	}

	public int insert(URole record) {
		return roleDao.insert(record);
	}

	public int insertSelective(URole record) {
		return roleDao.insertSelective(record);
	}

	public URole selectByPrimaryKey(Long id) {
		return roleDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(URole record) {
		return roleDao.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(URole record) {
		return roleDao.updateByPrimaryKeySelective(record);
	}

	public Set<String> findRoleByUserId(Long userId) {
		return roleDao.findRoleByUserId(userId);
	}

	public Map<String, Object> deleteRoleById(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<URole> findNowAllPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initData() {
		// TODO Auto-generated method stub

	}

	public List<URole> selectAll() {
		// TODO Auto-generated method stub
		return roleDao.selectAll();
	}

}
