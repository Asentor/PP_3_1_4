package org.xrave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xrave.model.Role;
import org.xrave.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleDao;

    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }
    public Set<Role> getRolesByIdList(List<Long> idList){
        Set<Role> result = new HashSet<>();
        for(Long id: idList){
            result.add(roleDao.findById(id).get());
        }
        return result;
    }
}
