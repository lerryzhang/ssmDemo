package com.cn.hnust.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp,
			Object mappedValue) throws Exception {
		Subject subject = getSubject(req, resp);
		String[] rolesArray = (String[]) mappedValue;
		if (rolesArray == null || rolesArray.length == 0) { // û�н�ɫ���ƣ���Ȩ�޷���
			return true;
		}
		for (int i = 0; i < rolesArray.length; i++) {
			if (subject.hasRole(rolesArray[i])) { // ����ǰ�û���rolesArray�е��κ�һ��������Ȩ�޷���
				return true;
			}
		}

		return false;
	}

}