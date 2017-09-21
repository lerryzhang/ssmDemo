package com.cn.hnust.domain;

import java.io.Serializable;

import net.sf.json.JSONObject;
/**
 * 
 * å¼?‘å…¬å¸ï¼šitboy.net<br/>
 * ç‰ˆæƒï¼šitboy.net<br/>
 * <p>
 * 
 * ç”¨æˆ·{@link UUser} å’Œè§’è‰?{@link URole} ä¸­é—´è¡?
 * 
 * <p>
 * 
 * åŒºåˆ†ã€?´£ä»»äººã€?—¥æœŸã?ã€??ã€?¯´æ˜?br/>
 * åˆ›å»ºã€?‘¨æŸæˆã€?016å¹?æœ?5æ—?ã€?br/>
 * <p>
 * *******
 * <p>
 * @author zhou-baicheng
 * @email  i@itboy.net
 * @version 1.0,2016å¹?æœ?5æ—?<br/>
 * 
 */
public class UUserRole  implements Serializable{
	private static final long serialVersionUID = 1L;
	 /**{@link UUser.id}*/
    private Long uid;
    /**{@link URole.id}*/
    private Long rid;

    public UUserRole(Long uid,Long rid) {
    	this.uid = uid;
    	this.rid = rid;
	}
    public UUserRole() {
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}