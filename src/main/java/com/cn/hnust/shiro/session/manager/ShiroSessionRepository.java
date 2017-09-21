package com.cn.hnust.shiro.session.manager;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

public interface ShiroSessionRepository {
	public void deleteSession(Serializable id);

	public Collection<Session> getAllSessions();

	public void saveSession(Session session);

	public Session getSession(Serializable id);

}
