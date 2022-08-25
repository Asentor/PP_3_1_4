package org.sterios.service;

import org.springframework.stereotype.Service;
import org.sterios.model.Role;
import org.sterios.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleDao;

    public RoleServiceImpl(RoleRepository roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    public Set<Role> getRolesByIdArr(Long[] idList) {
        Set<Role> result = new HashSet<>();
        for (Long id : idList) {
            result.add(roleDao.findById(id).get());
        }
        return result;
    }
}
