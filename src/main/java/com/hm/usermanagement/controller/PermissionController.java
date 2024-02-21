package com.hm.usermanagement.controller;

import com.hm.usermanagement.model.Permission;
import com.hm.usermanagement.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions(){
        List<Permission> permissions=permissionService.getAllPermissions();
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id){

        Optional<Permission> permission=permissionService.getPermissionById(id);
        return permission.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PostMapping
    public  ResponseEntity<Permission> createPermission(@RequestBody Permission permission){
        Permission createPermission=permissionService.createPermission(permission);
        return new ResponseEntity<>(createPermission,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(Long id, Permission permission){
        Permission updatePermission=permissionService.updatePermission(id,permission);
        if(updatePermission != null){
            return new ResponseEntity<>(updatePermission,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id){
    permissionService.deletePermission(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
