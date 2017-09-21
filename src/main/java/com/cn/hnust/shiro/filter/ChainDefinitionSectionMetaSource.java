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
	 * Ĭ��premission�ַ���
	 */
	public static final String PREMISSION_STRING = "perms[\"{0}\"]";

	public static final String ROLE_STRING = "roles[\"{0}\"]";

	public Section getObject() throws BeansException {

		// ��ȡ����Resource
		List<PermissionAllRole> list = permissionService
				.findRoleAndPermission();

		Ini ini = new Ini();
		// ����Ĭ�ϵ�url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

		// ѭ��Resource��url,�����ӵ�section�С�section����filterChainDefinitionMap,
		// ����ļ���������URL,ֵ���Ǵ���ʲô�������ܷ��ʸ�����

		for (Iterator<PermissionAllRole> it = list.iterator(); it.hasNext();) {

			PermissionAllRole resource = it.next();

			System.out.println("======" + resource.getType() + "==========="
					+ resource.getUrl());

			// �����Ϊ��ֵ��ӵ�section��
			if (StringUtils.isNotEmpty(resource.getUrl())
					&& StringUtils.isNotEmpty(resource.getType())) {

				section.put(resource.getUrl(), MessageFormat.format(
						ROLE_STRING, resource.getType()));
			}

		}

		return section;
	}

	/**
	 * ͨ��filterChainDefinitions��Ĭ�ϵ�url���˶���
	 * 
	 * @param filterChainDefinitions
	 *            Ĭ�ϵ�url���˶���
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
