package com.hm.usermanagement.service;

import com.hm.usermanagement.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> getAllRoles();

    public Optional<Role> getRoleById(Long id);

    public Role createRole(Role role);

    public Role updateRole(Long roleId, Role roleDetails);

    public void deleteRole(Long roleId);
}
