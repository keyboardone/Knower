package com.knower.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UBaseUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2531745066928087419L;

	private String userId;

    private String userEname;

    private String userCname;

    private String password;

    private String instId;//

    private String departId;//

    private String tel;

    private String mobile;

    private String address;

    private String email;

    private Date lastModifyDate;//

    private String isFirstLogin;//

    private BigDecimal wrongPwdCount;//

    private Date wrongPwdDate;//

    private String isUserLocked;//

    private String userLockedReson;//

    private Date startDate;//

    private Date endDate;//

    private Date createTime;

    private String description;

    private String enabled;

    private String isDelete;//

    private Date lastLoginDate;//

    private String isList;//

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserEname() {
        return userEname;
    }

    public void setUserEname(String userEname) {
        this.userEname = userEname == null ? null : userEname.trim();
    }

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname == null ? null : userCname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(String isFirstLogin) {
        this.isFirstLogin = isFirstLogin == null ? null : isFirstLogin.trim();
    }

    public BigDecimal getWrongPwdCount() {
        return wrongPwdCount;
    }

    public void setWrongPwdCount(BigDecimal wrongPwdCount) {
        this.wrongPwdCount = wrongPwdCount;
    }

    public Date getWrongPwdDate() {
        return wrongPwdDate;
    }

    public void setWrongPwdDate(Date wrongPwdDate) {
        this.wrongPwdDate = wrongPwdDate;
    }

    public String getIsUserLocked() {
        return isUserLocked;
    }

    public void setIsUserLocked(String isUserLocked) {
        this.isUserLocked = isUserLocked == null ? null : isUserLocked.trim();
    }

    public String getUserLockedReson() {
        return userLockedReson;
    }

    public void setUserLockedReson(String userLockedReson) {
        this.userLockedReson = userLockedReson == null ? null : userLockedReson.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getIsList() {
        return isList;
    }

    public void setIsList(String isList) {
        this.isList = isList == null ? null : isList.trim();
    }
}