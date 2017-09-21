package com.cn.hnust.domain;

import java.io.Serializable;

import net.sf.json.JSONObject;
/**
 * 
 * �?��公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 用户{@link UUser} 和角�?{@link URole} 中间�?
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