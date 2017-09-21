package com.cn.hnust.shiro.session.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;

import com.cn.hnust.domain.User;
import com.cn.hnust.user.bo.UserOnlineBo;

public class CustomSessionManager {

	/**
	 * session status
	 */
	public static final String SESSION_STATUS = "sojson-online-status";
	ShiroSessionRepository shiroSessionRepository;

	CustomShiroSessionDao customShiroSessionDao;

	public List<UserOnlineBo> getAllUser() {

		Collection<Session> sessions = customShiroSessionDao
				.getActiveSessions();
		List<UserOnlineBo> list = new ArrayList<UserOnlineBo>();

		for (Session session : sessions) {
			UserOnlineBo bo = getSessionBo(session);
			if (null != bo) {
				list.add(bo);
			}
		}
		return list;
	}

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setCustomShiroSessionDao(
			CustomShiroSessionDao customShiroSessionDao) {
		this.customShiroSessionDao = customShiroSessionDao;
	}

	/**
	 * 根据ID查询 SimplePrincipalCollection
	 * 
	 * @param userIds
	 *            用户ID
	 * @return
	 */

	public List<SimplePrincipalCollection> getSimplePrincipalCollectionByUserId(
			Long... userIds) {

		List<SimplePrincipalCollection> list = new ArrayList<SimplePrincipalCollection>();

		return list;
	}

	/**
	 * 获取单个Session
	 * 
	 * @param sessionId
	 * @return
	 */
	public UserOnlineBo getSession(String sessionId) {
		Session session = shiroSessionRepository.getSession(sessionId);
		UserOnlineBo bo = getSessionBo(session);
		return bo;
	}

	private UserOnlineBo getSessionBo(Session session) {

		Object obj = session
				.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
		if (null == obj) {
			return null;
		}

		if (obj instanceof SimplePrincipalCollection) {
			SimplePrincipalCollection spc = (SimplePrincipalCollection) obj;

			obj = spc.getPrimaryPrincipal();
			if (null != obj && obj instanceof User) {

				UserOnlineBo userBo = new UserOnlineBo((User) obj);

				userBo.setLastAccess(session.getLastAccessTime());

				userBo.setHost(session.getHost());
				// session ID
				userBo.setSessionId(session.getId().toString());

				userBo.setLastLoginTime(session.getLastAccessTime());
				// 回话到期 ttl(ms)
				userBo.setTimeout(session.getTimeout());

				userBo.setStartTime(session.getStartTimestamp());
				// 是否踢出
				SessionStatus sessionStatus = (SessionStatus) session
						.getAttribute(SESSION_STATUS);
				boolean status = Boolean.TRUE;
				if (null != sessionStatus) {
					status = sessionStatus.getOnlineStatus();
				}
				userBo.setSessionStatus(status);
				return userBo;
			}
		}
		return null;
	}

	public Map<String, Object> changeSessionStatus(Boolean status,
			String sessionIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String[] sessionIdArray = null;
			if (sessionIds.indexOf(",") == -1) {
				sessionIdArray = new String[] { sessionIds };
			} else {
				sessionIdArray = sessionIds.split(",");
			}
			for (String id : sessionIdArray) {
				Session session = shiroSessionRepository.getSession(id);
				SessionStatus sessionStatus = new SessionStatus();
				sessionStatus.setOnlineStatus(status);
				session.setAttribute(SESSION_STATUS, sessionStatus);
				customShiroSessionDao.update(session);
			}
			map.put("status", 200);
			map.put("sessionStatus", status ? 1 : 0);
			map.put("sessionStatusText", status ? "踢出" : "");
			map.put("sessionStatusTextTd", status ? "有效" : "");
		} catch (Exception e) {
			map.put("status", 500);
			map.put("message", "改变失败，有可能Session不存在，请刷新再试！");
		}
		return map;
	}

	public void forbidUserById(Long id, Long status) {

	}

	public void setShiroSessionRepository(
			ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

}
