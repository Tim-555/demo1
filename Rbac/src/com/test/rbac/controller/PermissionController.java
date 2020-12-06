package com.test.rbac.controller;

import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IPermissionService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired(required = false)
    private IPermissionService permissionService;


    /*
    * 加载权限操作
    * */
    @RequestMapping("reload")
    public void reload() {
        permissionService.reload();

    }


    @RequestMapping("list")
    public String query(Model model, @ModelAttribute("qo") QueryObject qo) throws Exception {

        PageResult result = permissionService.query(qo);
        model.addAttribute("result", result);
        return "permission/list";
    }

    //删除操作
    @RequestMapping("delete")
    public String delete(Long id) {
        if (id != null) {
            permissionService.delete(id);
        }

        return "redirect:permission/list.do";
    }


}
