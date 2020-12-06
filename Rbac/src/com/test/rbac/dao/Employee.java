package com.test.rbac.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseDomain {
    private String name;
    private String password;
    private Integer age;
    private String email;
    private boolean admin; //管理员

    //多对1
    private Department dept;

}
