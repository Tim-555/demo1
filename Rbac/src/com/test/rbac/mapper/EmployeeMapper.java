package com.test.rbac.mapper;

import com.test.rbac.dao.Employee;
import com.test.rbac.qo.QueryObject;

import java.util.List;

public interface EmployeeMapper {
    void save(Employee employee);

    void delete(Long id);

    void update(Employee employee);

    Employee get(Long id);
    List<Employee> list();


    /*
  *
  * 按条件查询数据
  * */
    List<Employee> queryForList(QueryObject qo);

    /*
*
* 按条件查询总条数
* */
    int queryForCount(QueryObject qo);


}
