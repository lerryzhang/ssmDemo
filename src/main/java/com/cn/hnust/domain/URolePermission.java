package com.cn.hnust.domain;

import java.io.Serializable;

import net.sf.json.JSONObject;
/**
 * 
 * �?��公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 角色{@link URole}�?权限{@link UPermission}中间�?
 * 
 * <p>
 * 
 * 区分�?��任人�?��期�?�??�?���?br/>
 * 创建�?��柏成�?016�?�?5�?�?br/>
 * <p>
 * *******
 * <p>
 * @author zhou-baicheng
 * @email  i@itboy.net
 * @version 1.0,2016�?�?5�?<br/>
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