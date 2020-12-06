package com.test.rbac.controller;

import com.test.rbac.annotation.RequiredPermission;
import com.test.rbac.dao.Department;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IDepartmentService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired(required = false)
    private IDepartmentService departmentService;

    @RequiredPermission("部门查询全部操作")
    @RequestMapping("list")
    public String query(Model model, @ModelAttribute("qo") QueryObject qo) throws Exception {
        //查询的是部门跟分页信息
        PageResult result = departmentService.query(qo);

        model.addAttribute("result", result);

        return "department/list";

    }

    @RequiredPermission("部门编辑操作")
    //编辑操作
    @RequestMapping("input")
    public String input(Model model, Long id) {
        Department department = departmentService.get(id);

        if (id != null) {
            model.addAttribute("entity", department);
        }
        return "department/input";
    }

    @RequiredPermission("部门新增/保存操作")
    //保存/新增
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Department department) {
        departmentService.saveOrUpdate(department);

        return "redirect:department/list.do";
    }

    @RequiredPermission("部门删除操作")
    //删除操作
    @RequestMapping("delete")
    public String delete(Long id) {
        if (id != null) {
            departmentService.delete(id);
        }

        return "redirect:department/list.do";
    }


}
