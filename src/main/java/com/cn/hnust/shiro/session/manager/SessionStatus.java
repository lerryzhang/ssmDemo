package com.cn.hnust.shiro.session.manager;

import java.io.Serializable;

public class SessionStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean onlineStatus = Boolean.TRUE;

	public Boolean isOnlineStatus() {
		return onlineStatus;
	}

	public Boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

}
