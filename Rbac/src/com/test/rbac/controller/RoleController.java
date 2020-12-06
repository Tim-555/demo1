package com.test.rbac.controller;

import com.test.rbac.dao.Permission;
import com.test.rbac.dao.Role;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IPermissionService;
import com.test.rbac.service.IRoleService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo) throws Exception {
        PageResult result = roleService.query(qo);
        model.addAttribute("result", result);

        return "role/list";
    }


    /*
    * 编辑操作
    * */
    @RequestMapping("input")
    public String input(Long id, Model model) throws Exception {
        List<Permission> list = permissionService.list();
        model.addAttribute("permissions", list);
        if (id != null) {
            Role role = roleService.get(id);
            model.addAttribute("role", role);
        }


        return "role/input";
    }

    /*
    * 新增/保存操作
    * */
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Role role) throws Exception {
        roleService.saveOrUpdate(role);
        return "redirect:/role/list.do";

    }

    @RequestMapping("delete")
    public String delete(Long id) {
        roleService.delete(id);
        return "redirect:/role/list.do";

    }



}
