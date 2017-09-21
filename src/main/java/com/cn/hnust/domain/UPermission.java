package com.cn.hnust.domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

/**
 * 
 * å¼?‘å…¬å¸ï¼šitboy.net<br/>
 * ç‰ˆæƒï¼šitboy.net<br/>
 * <p>
 * 
 * æƒé™å®ä½“
 * 
 * <p>
 * 
 * åŒºåˆ†ã€?´£ä»»äººã€?—¥æœŸã?ã€??ã€?¯´æ˜?br/>
 * åˆ›å»ºã€?‘¨æŸæˆã€?016å¹?æœ?5æ—?ã€?br/>
 * <p>
 * *******
 * <p>
 * 
 * @author zhou-baicheng
 * @email i@itboy.net
 * @version 1.0,2016å¹?æœ?5æ—?<br/>
 * 
 */
public class UPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	/** æ“ä½œçš„url */
	private String url;
	/** æ“ä½œçš„åç§?*/
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}