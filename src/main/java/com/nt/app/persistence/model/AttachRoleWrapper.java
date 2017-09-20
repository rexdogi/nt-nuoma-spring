package com.nt.app.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AttachRoleWrapper {

    private List<String> roleIds;
    private String userId;

    public AttachRoleWrapper(@JsonProperty("roleIds") List<String> roleIds, @JsonProperty("userId") String userId) {
        this.roleIds = roleIds;
        this.userId = userId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
