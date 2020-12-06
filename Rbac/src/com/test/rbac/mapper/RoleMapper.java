package com.test.rbac.mapper;

import com.test.rbac.dao.Role;
import com.test.rbac.qo.QueryObject;

import java.util.List;

public interface RoleMapper {
    void save(Role role);

    void delete(Long id);

    void update(Role role);


    Role get(Long id );
    List<Role> list();


    int queryForCount(QueryObject qo);

    List<Role> queryForList(QueryObject qo);



}
