package com.hm.usermanagement.service.impl;

import com.hm.usermanagement.model.Role;
import com.hm.usermanagement.repository.RoleRepository;
import com.hm.usermanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role roleDetails) {
        Optional<Role> optionalRole=roleRepository.findById(id);
        if(optionalRole.isPresent()){
            Role role=optionalRole.get();
            role.setName(roleDetails.getName());
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
