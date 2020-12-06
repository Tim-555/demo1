package com.test.rbac.service;

import com.test.rbac.dao.Role;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.util.PageResult;

import java.util.List;

public interface IRoleService {
    void saveOrUpdate(Role role);

    void delete(Long id);

    Role get(Long id );

    List<Role> list();

    PageResult query(QueryObject qo);
}
