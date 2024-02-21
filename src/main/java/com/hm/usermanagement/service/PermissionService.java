package com.hm.usermanagement.service;

import com.hm.usermanagement.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    public List<Permission> getAllPermissions();

    public Optional<Permission> getPermissionById(Long id);

    public Permission createPermission(Permission permission);

    public Permission updatePermission(Long id, Permission permission);

    public void deletePermission(Long id);
}
