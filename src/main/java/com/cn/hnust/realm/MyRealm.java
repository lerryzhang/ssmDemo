package com.cn.hnust.realm;

import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cn.hnust.domain.User;
import com.cn.hnust.service.PermissionService;
import com.cn.hnust.service.RoleService;
import com.cn.hnust.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;

	@Resource
	private PermissionService permissionService;

	private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

	/**
	 * 授权
	 * 
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		logger.info("--- MyRealm doGetAuthorizationInfo ---");
		System.out.println("======授权==========");

		String token = SecurityUtils.getSubject().getPrincipal().toString();

		User user = userService.selectByUsername(token);

		Long userId = user.getId() == null ? null : user.getId();

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Set<String> roles = roleService.findRoleByUserId(userId);

		for (String role : roles) {
			System.out.println("=========" + role);
		}

		info.setRoles(roles);
		// 根据用户ID查询权限（permission），放入到Authorization里。
		Set<String> permissions = permissionService
				.findPermissionByUserId(userId);

		info.setStringPermissions(permissions);
		return info;

	}

	/**
	 * 认证
	 * 
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {

		logger.info("--- MyRealm doGetAuthenticationInfo ---");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		if (StringUtils.isEmpty(username))
			throw new UnknownAccountException();
		User user = userService.selectByUsername(username);

		if (user == null) {
			throw new UnknownAccountException();
		} else if (String.valueOf(token.getPassword()).equals(user.getPswd())) {

			user.setLastLoginTime(new Date());
			userService.updateByPrimaryKeySelective(user);

		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getNickname(), // 用户名
				user.getPswd(), getName() // realm name
		);
		return authenticationInfo;
	}
}