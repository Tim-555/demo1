package com.test.rbac.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/*
* 员工
* */
public class Employee extends BaseDomain {
    private String name;
    private String password;
    private Integer age;
    private String email;
    private boolean admin; //管理员

    //多对1
    private Department dept;

}
