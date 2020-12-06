package com.test.rbac.mapper;

import com.test.rbac.dao.Department;
import com.test.rbac.qo.QueryObject;

import java.util.List;

//@Repository
public interface DepartmentMapper {
    void save(Department department);

    void delete(Long id);

    void update(Department department);

    Department get(Long id);

    List<Department> list();

    int queryForCount(QueryObject qo);

    List<Department> queryForList(QueryObject qo);


}
