package com.test.rbac.mapper;

import com.test.rbac.dao.Permission;
import com.test.rbac.qo.QueryObject;

import java.util.List;

public interface PermissionMapper {
    void save(Permission entity);

    void delete(Long id);

    List<Permission> list();

    int queryForCount(QueryObject qo);
    List<Permission> queryForList(QueryObject qo);


    List<String> selectPermissionExpression();
}
