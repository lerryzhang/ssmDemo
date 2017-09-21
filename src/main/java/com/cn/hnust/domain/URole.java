package com.cn.hnust.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;
/**
 * 
 * å¼?‘å…¬å¸ï¼šitboy.net<br/>
 * ç‰ˆæƒï¼šitboy.net<br/>
 * <p>
 * 
 * æƒé™è§’è‰²
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
public class URole  implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;
    /**è§’è‰²åç§°*/
    private String name;
    /**è§’è‰²ç±»å‹*/
    private String type;
    //***å?role --> permission ä¸?¯¹å¤šå¤„ç?
    private List<UPermission> permissions = new LinkedList<UPermission>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public List<UPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<UPermission> permissions) {
		this.permissions = permissions;
	}

	public void setType(String type) {
        this.type = type;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}