package com.test.rbac.service;

import com.test.rbac.dao.Employee;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.util.PageResult;

import java.util.List;


public interface IEmployeeService {
    void saveOrUpdate(Employee employee);

    void delete(Long id);


    Employee get(Long id);

    List<Employee> list();


    PageResult query(QueryObject qo);


}
