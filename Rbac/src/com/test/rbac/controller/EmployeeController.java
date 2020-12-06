package com.test.rbac.controller;

import com.test.rbac.annotation.RequiredPermission;
import com.test.rbac.dao.Department;
import com.test.rbac.dao.Employee;
import com.test.rbac.qo.EmployeeQueryObject;
import com.test.rbac.service.IDepartmentService;
import com.test.rbac.service.IEmployeeService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {


    @Autowired(required = false)
    public IEmployeeService employeeService;

    @Autowired(required = false)
    public IDepartmentService departmentService;


    @RequiredPermission("员工查询全部操作")
    //EmployeeQueryObject 改为QueryObject
    @RequestMapping("list")
    public String query(Model model, @ModelAttribute("qo") EmployeeQueryObject qo) throws Exception {
        //查询所有员工和分页信息
        PageResult result = employeeService.query(qo);
        model.addAttribute("result", result);
        // model.addAttribute("qo", qo); 不用这样,直接@ModelAttribute("qo")这个,要不默认是自定义类型的首字母小写employeeQueryObject

        List<Department> depts = departmentService.list();
        //部门
        model.addAttribute("depts", depts);
        return "employee/list";

    }

    @RequiredPermission("员工编辑操作")
    @RequestMapping("input")
    public String input(Long id, Model model) throws Exception {
        List<Department> depts = departmentService.list();
        //部门
        model.addAttribute("depts", depts);

        if (id != null) {
            Employee employee = employeeService.get(id);
            model.addAttribute("employee", employee);

        }

        return "employee/input";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee employee) throws Exception {
        employeeService.saveOrUpdate(employee);

        return "redirect:employee/list.do";
    }

    @RequiredPermission("员工删除操作")
    @RequestMapping("delete")
    public String delete(Long id) throws Exception {
        if (id != null) {
            employeeService.delete(id);
        }
        return "redirect:employee/list.do";
    }
}
