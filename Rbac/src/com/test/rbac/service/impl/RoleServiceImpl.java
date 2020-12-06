package com.test.rbac.service.impl;

import com.test.rbac.dao.Role;
import com.test.rbac.mapper.RoleMapper;
import com.test.rbac.qo.QueryObject;
import com.test.rbac.service.IRoleService;
import com.test.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    public void saveOrUpdate(Role role) {
        if (role.getId() == null) {
            roleMapper.save(role);

        } else {
            roleMapper.update(role);

        }


    }

    public void delete(Long id) {
        if (id != null) {
            roleMapper.delete(id);
        }


    }

    public Role get(Long id) {
      return   roleMapper.get(id);

    }

    public List<Role> list() {

        return roleMapper.list();
    }

    public PageResult query(QueryObject qo) {
        int count = roleMapper.queryForCount(qo);
        if (count == 0) {
            return PageResult.EMPTY_PAGE;
        }
        List<Role> list = roleMapper.queryForList(qo);

        return new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, list);
    }


}
