package com.test.rbac.service.impl;

import com.test.rbac.dao.Employee;
import com.test.rbac.mapper.EmployeeMapper;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IEmployeeService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired(required = false)
    public EmployeeMapper employeeMapper;


    public void saveOrUpdate(Employee employee) {
        employeeMapper.save(employee);

    }

    public void delete(Long id) {
        if (id != null) {
            employeeMapper.delete(id);
        }
    }


    public Employee get(Long id) {

        return employeeMapper.get(id);
    }

    public List<Employee> list() {
        List<Employee> list = employeeMapper.list();

        return list;
    }

    public PageResult query(QueryObject qo) {
        //查总数
        int count = employeeMapper.queryForCount(qo);
        if (count == 0) {
            return PageResult.EMPTY_PAGE;
        }
        List<?> list = employeeMapper.queryForList(qo);

        return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, list);
    }


}
