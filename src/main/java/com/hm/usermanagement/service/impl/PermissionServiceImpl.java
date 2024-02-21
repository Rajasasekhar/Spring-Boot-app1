package com.hm.usermanagement.service.impl;

import com.hm.usermanagement.model.Permission;
import com.hm.usermanagement.repository.PermissionRepository;
import com.hm.usermanagement.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Optional<Permission> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission updatePermission(Long id, Permission newPermission) {
        Optional<Permission> optionalPermission=permissionRepository.findById(id);
        if(optionalPermission.isPresent()){
            Permission permission=optionalPermission.get();
            permission.setName(newPermission.getName());
            return permissionRepository.save(permission);
        }
        return null;
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
