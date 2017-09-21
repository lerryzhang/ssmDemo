package com.cn.hnust.shiro.session.manager;

import org.apache.shiro.cache.Cache;

public class JedisShiroCacheManager implements ShiroCacheManager {

	private RedisManager redisManager;

	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	public <K, V> Cache<K, V> getCache(String name) {
		return new JedisShiroCache<K, V>(redisManager, name);
	}

	public void destroy() {

		redisManager.flushDB();
	}
}