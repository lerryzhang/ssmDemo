package com.cn.hnust.shiro.listenter;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.cn.hnust.shiro.session.manager.ShiroSessionRepository;

public class CustomSessionListener implements SessionListener {

	private ShiroSessionRepository shiroSessionRepository;

	public void onStart(Session session) {
		// TODO
		System.out.println("on start" + session.getTimeout());
	}

	public void onStop(Session session) {
		// TODO
		System.out.println("on stop");
	}

	public void onExpiration(Session session) {
		System.out.println("=====+session  过期");
		shiroSessionRepository.deleteSession(session.getId());
	}

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(
			ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

}
