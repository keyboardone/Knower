package com.system.common.entity;


public class UBaseMenu {
    private String systemId;

    private String menuId;

    private String menuName;

    private String target;

    private String url;

    private String imgSrc;

    private Long orderNum;

    private String display;

    private String enabled;

    private String menuParentId;

    private String lev;
    
    private UAuthRoleResource uAuthRoleResource;
    
    private UAuthRoleUser uAuthRoleUser;
    
    private String roleId;

    public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public UAuthRoleResource getuAuthRoleResource() {
		return uAuthRoleResource;
	}

	public void setuAuthRoleResource(UAuthRoleResource uAuthRoleResource) {
		this.uAuthRoleResource = uAuthRoleResource;
	}

	public UAuthRoleUser getuAuthRoleUser() {
		return uAuthRoleUser;
	}

	public void setuAuthRoleUser(UAuthRoleUser uAuthRoleUser) {
		this.uAuthRoleUser = uAuthRoleUser;
	}

	public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display == null ? null : display.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId == null ? null : menuParentId.trim();
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev == null ? null : lev.trim();
    }
}