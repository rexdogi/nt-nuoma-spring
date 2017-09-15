package com.nt.app.persistence.model;

public class AttachRoleWrapper {

    private long[] roleIds;
    private Long userId;

    public AttachRoleWrapper(long[] roleIds, Long userId) {
        this.roleIds = roleIds;
        this.userId = userId;
    }

    public long[] getRoleIds() {
        return roleIds;
    }

    public Long getUserId() {
        return userId;
    }
}
