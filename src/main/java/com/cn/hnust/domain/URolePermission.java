package com.cn.hnust.domain;

import java.io.Serializable;

import net.sf.json.JSONObject;
/**
 * 
 * å¼?‘å…¬å¸ï¼šitboy.net<br/>
 * ç‰ˆæƒï¼šitboy.net<br/>
 * <p>
 * 
 * è§’è‰²{@link URole}å’?æƒé™{@link UPermission}ä¸­é—´è¡?
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
public class URolePermission  implements Serializable{
	private static final long serialVersionUID = 1L;
	/**{@link URole.id}*/
    private Long rid;
    /**{@link UPermission.id}*/
    private Long pid;

    public URolePermission() {
	}
    public URolePermission(Long rid,Long pid) {
    	this.rid = rid;
    	this.pid = pid;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}