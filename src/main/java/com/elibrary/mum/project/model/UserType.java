package com.elibrary.mum.project.model;

import java.util.ArrayList;
import java.util.List;

public class UserType {
    private Long userTypeId;
    private String userTypeName;
    private List<User> users = new ArrayList<User>();

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

}
