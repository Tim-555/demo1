package com.test.rbac.dao;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//权限
public class Permission extends BaseDomain {
    public String name;
    public String expression; //表达式


}
