package org.sterios.service;

import org.sterios.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Set<Role> getRolesByIdArr(Long[] idList);
}
