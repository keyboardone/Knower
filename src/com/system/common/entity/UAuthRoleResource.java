package com.system.common.entity;

public class UAuthRoleResource {
    private String objectId;

    private String resId;

    private String resDetailValue;

    private String resDetailName;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getResDetailValue() {
        return resDetailValue;
    }

    public void setResDetailValue(String resDetailValue) {
        this.resDetailValue = resDetailValue == null ? null : resDetailValue.trim();
    }

    public String getResDetailName() {
        return resDetailName;
    }

    public void setResDetailName(String resDetailName) {
        this.resDetailName = resDetailName == null ? null : resDetailName.trim();
    }
}