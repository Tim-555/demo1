package com.test.rbac.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*
* j角色
* */
public class Role extends BaseDomain {
    private String name;
    private String sn;

    //权限
    private List<Permission> permissions = new ArrayList<>();

}
