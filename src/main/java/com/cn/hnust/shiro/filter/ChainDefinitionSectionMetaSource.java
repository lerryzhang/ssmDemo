package com.cn.hnust.shiro.filter;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.hnust.domain.PermissionAllRole;
import com.cn.hnust.service.PermissionService;

public class ChainDefinitionSectionMetaSource implements
		FactoryBean<Ini.Section> {

	@Autowired
	private PermissionService permissionService;

	private String filterChainDefinitions;

	/**
	 * 默认premission字符串
	 */
	public static final String PREMISSION_STRING = "perms[\"{0}\"]";

	public static final String ROLE_STRING = "roles[\"{0}\"]";

	public Section getObject() throws BeansException {

		// 获取所有Resource
		List<PermissionAllRole> list = permissionService
				.findRoleAndPermission();

		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接

		for (Iterator<PermissionAllRole> it = list.iterator(); it.hasNext();) {

			PermissionAllRole resource = it.next();

			System.out.println("======" + resource.getType() + "==========="
					+ resource.getUrl());

			// 如果不为空值添加到section中
			if (StringUtils.isNotEmpty(resource.getUrl())
					&& StringUtils.isNotEmpty(resource.getType())) {

				section.put(resource.getUrl(), MessageFormat.format(
						ROLE_STRING, resource.getType()));
			}

		}

		return section;
	}

	/**
	 * 通过filterChainDefinitions对默认的url过滤定义
	 * 
	 * @param filterChainDefinitions
	 *            默认的url过滤定义
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions) {

		this.filterChainDefinitions = filterChainDefinitions;
	}

	public Class<?> getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return false;
	}

}
