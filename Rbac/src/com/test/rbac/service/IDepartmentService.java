package com.test.rbac.service;

import com.test.rbac.dao.Department;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.util.PageResult;

import java.util.List;

public interface IDepartmentService {
    void saveOrUpdate(Department department);

    void delete(Long id);


    Department get(Long id);

    List<Department> list();

    PageResult query(QueryObject qo);

}
