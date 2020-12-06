package com.test.rbac.service.impl;

import com.test.rbac.annotation.RequiredPermission;
import com.test.rbac.dao.Permission;
import com.test.rbac.mapper.PermissionMapper;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IPermissionService;
import com.test.rbac.util.PageResult;
import com.test.rbac.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionMapper;

    //Spring 容器对象
    @Autowired
    private ApplicationContext ctx;

    public void save(Permission entity) {

    }

    public void delete(Long id) {
        permissionMapper.delete(id);

    }

    public List<Permission> list() {
        return null;
    }

    public PageResult query(QueryObject qo) {
        int count = permissionMapper.queryForCount(qo);
        if (count == 0) {
            return PageResult.EMPTY_PAGE;
        }
        List<Permission> list = permissionMapper.queryForList(qo);
        return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, list);
    }

    /*
    * 加载
    * */
    public void reload() {

        //先查出所有的表达式
        List<String> exprs = permissionMapper.selectPermissionExpression();
        //容器对象根据@Controller字节码反射机制找到Controller类
        Map<String, Object> cons = ctx.getBeansWithAnnotation(Controller.class);
        //具体的controller对象集合
        Collection<Object> values = cons.values();
        for (Object con : values) {
            //找到controller类中的所有方法
            Method[] method = con.getClass().getDeclaredMethods();
            for (Method m : method) {
                //找到表达式
                String expression = PermissionUtil.buildExpression(m);
                if (exprs.contains(expression)) {
                    continue; //库中有,就跳出当前循环
                }
                //查看获取的所有方法是否贴有@RequiredPermission 注解
                RequiredPermission anno = m.getAnnotation(RequiredPermission.class);
                if (anno != null) {
                    Permission p = new Permission();
                    p.setName(anno.value()); //权限名称
                    p.setExpression(expression); //权限表达式
                    permissionMapper.save(p);
                }

            }

        }

    }


}




