package com.test.rbac.util;

import java.lang.reflect.Method;

/*
* 权限工具类
* */
public class PermissionUtil {

    public static String  buildExpression(Method method) {
        String name = method.getDeclaringClass().getName();
        return name + ":" + method.getName();
    }
}
