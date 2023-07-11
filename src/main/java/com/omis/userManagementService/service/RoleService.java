package com.omis.userManagementService.service;


import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    boolean createRole(Long id, String roleName, boolean status, Long categoryId);


    List<Role> getAllRoles();


    List<Route> getAllRoutes();

    void deleteRole(Long id);

    boolean updateRole(Long id, String roleName, Boolean status, Long categoryId);
}
