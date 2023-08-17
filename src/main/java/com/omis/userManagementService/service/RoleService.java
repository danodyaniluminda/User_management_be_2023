package com.omis.userManagementService.service;


import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.models.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    boolean createRole(Long id, String roleName, boolean status, Long categoryId);


    List<Role> getAllRoles();


    List<Route> getAllRoutes();

    List<Roleroute> getAllRolerRouteNames();



    void deleteRole(Long id);

    boolean updateRole(Long id, String roleName, Boolean status, Long categoryId);


    boolean updateRoleRouteDelete(Long id, Boolean delete);

    boolean updateRoleRouteEdit(Long id, Boolean edit);

    boolean updateRoleRouteAdd(Long id, Boolean add);

    boolean updateRoleRouteAll(Long id, Boolean add, Boolean edit, Boolean delete);
}
