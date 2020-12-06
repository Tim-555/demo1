package com.test.rbac.service;

import com.test.rbac.dao.Permission;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.util.PageResult;

import java.util.List;

public interface IPermissionService {
    void save(Permission entity);

    void delete(Long id);

    List<Permission> list();

    PageResult query(QueryObject qo);



    void reload();
}
