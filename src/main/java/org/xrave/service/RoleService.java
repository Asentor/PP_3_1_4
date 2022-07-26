package org.xrave.service;

import org.xrave.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Set<Role> getRolesByIdArr(Long[] idList);
}
