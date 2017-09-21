package com.cn.hnust.shiro.session.manager;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;

import com.cn.hnust.util.SerializeUtils;

public class JedisShiroSessionRepository implements ShiroSessionRepository {

	private RedisManager redisManager;

	private final String REDIS_SHIRO_SESSION = "shiro-session";

	public void saveSession(Session session) {

		if (session == null || session.getId() == null) {
			System.out.println("session 或者 session ID 为空");
			return;
		}
		byte[] key = SerializeUtils.serialize(getRedisSessionKey(session
				.getId()));
		byte[] value = SerializeUtils.serialize(session);

		Long timeOut = session.getTimeout() / 1000;
		redisManager.set(key, value, Integer.parseInt(timeOut.toString()));

	}

	public void deleteSession(Serializable sessionId) {

		if (sessionId == null) {
			System.out.println("id为空");
			return;
		}
		redisManager.del(SerializeUtils
				.serialize(getRedisSessionKey(sessionId)));

	}

	public Session getSession(Serializable sessionId) {

		if (null == sessionId) {
			System.out.println("id为空");
			return null;
		}
		Session session = null;
		byte[] value = redisManager.get(SerializeUtils
				.serialize(getRedisSessionKey(sessionId)));
		if (null == value)
			return null;
		session = (Session) SerializeUtils.deserialize(value);
		return session;
	}

	public Collection<Session> getAllSessions() {

		Set<Session> sessions = new HashSet<Session>();
		Set<byte[]> byteKeys = redisManager
				.keys(this.REDIS_SHIRO_SESSION + "*");
		if (byteKeys != null && byteKeys.size() > 0) {
			for (byte[] bs : byteKeys) {
				Session s = (Session) SerializeUtils.deserialize(redisManager
						.get(bs));
				sessions.add(s);
			}
		}
		return sessions;
	}

	/**
	 * 获取redis中的session key
	 * 
	 * @param sessionId
	 * @return
	 */
	private String getRedisSessionKey(Serializable sessionId) {
		return this.REDIS_SHIRO_SESSION + sessionId;
	}

	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	public JedisShiroSessionRepository() {

	}
}
