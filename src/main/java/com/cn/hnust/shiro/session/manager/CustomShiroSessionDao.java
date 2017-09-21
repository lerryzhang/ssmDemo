package com.cn.hnust.shiro.session.manager;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

public class CustomShiroSessionDao extends AbstractSessionDAO {

	private ShiroSessionRepository shiroSessionRepository;

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(
			ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

	public void delete(Session session) {
		if (session == null) {
			System.out.println("´íÎó");
			return;
		}
		Serializable id = session.getId();
		if (id != null)
			getShiroSessionRepository().deleteSession(id);

	}

	public Collection<Session> getActiveSessions() {
		return getShiroSessionRepository().getAllSessions();
	}

	public void update(Session session) throws UnknownSessionException {
		getShiroSessionRepository().saveSession(session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		session.setTimeout(180000);
		Serializable sessionId = this.generateSessionId(session);
		System.out.println("===" + session.getHost() + "===="
				+ session.getTimeout() + "==" + session.getLastAccessTime()
				+ "===" + session.getStartTimestamp());
		this.assignSessionId(session, sessionId);
		getShiroSessionRepository().saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return getShiroSessionRepository().getSession(sessionId);
	}

}
