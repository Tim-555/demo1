package com.test.rbac.service.impl;

import com.test.rbac.dao.Department;
import com.test.rbac.mapper.DepartmentMapper;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IDepartmentService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired(required = false)
    private DepartmentMapper departmentMapper; //这里在mapper那边不贴@Repository会报错,但是没问题的,可能是idea问题,毕竟我在配置文件中配了mapper的扫描

    public void save(Department department) {

    }

    public void saveOrUpdate(Department department) {

    }

    public void delete(Long id) {

    }


    public Department get(Long id) {
        return departmentMapper.get(id);
    }

    public List<Department> list() {

        List<Department> list = departmentMapper.list();

        return list;
    }

    public PageResult query(QueryObject qo) {
        int count = departmentMapper.queryForCount(qo);
        if (count == 0) {
            return PageResult.EMPTY_PAGE;
        }
        List<Department> list = departmentMapper.queryForList(qo);
        return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, list);
    }
}
