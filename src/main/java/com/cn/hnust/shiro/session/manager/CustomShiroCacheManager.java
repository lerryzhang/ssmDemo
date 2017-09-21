package com.cn.hnust.shiro.session.manager;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

public class CustomShiroCacheManager implements CacheManager, Destroyable {

	private ShiroCacheManager shrioCacheManager;

	public ShiroCacheManager getShrioCacheManager() {
		return shrioCacheManager;
	}

	public void setShrioCacheManager(ShiroCacheManager shrioCacheManager) {
		this.shrioCacheManager = shrioCacheManager;
	}

	public void destroy() throws Exception {
		getShrioCacheManager().destroy();
	}

	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return getShrioCacheManager().getCache(name);
	}

}