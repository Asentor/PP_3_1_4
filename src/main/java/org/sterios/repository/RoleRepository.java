package org.sterios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sterios.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
