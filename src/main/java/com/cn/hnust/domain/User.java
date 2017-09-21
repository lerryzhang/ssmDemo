package com.cn.hnust.domain;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 0:��ֹ��¼
	public static final Long _0 = new Long(0);
	// 1:��Ч
	public static final Long _1 = new Long(1);
	private Long id;
	/** �ǳ� */
	private String nickname;
	/** ���� | ��¼�ʺ� */
	private String email;
	/** ���� */
	private transient String pswd;
	/** ����ʱ�� */
	private Date createTime;
	/** ����¼ʱ�� */
	private Date lastLoginTime;
	/** 1:��Ч��0:��ֹ��¼ */
	private Long status;

	public User() {
	}

	public User(User user) {
		this.id = user.getId();
		this.nickname = user.getNickname();
		this.email = user.getEmail();
		this.pswd = user.getPswd();
		this.createTime = user.getCreateTime();
		this.lastLoginTime = user.getLastLoginTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}