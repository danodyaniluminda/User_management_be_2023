package com.omis.userManagementService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Route;

import java.util.List;
import java.util.Optional;

public interface RoleRouteService {
    List<Route> getAll(Optional<Role> role) throws JsonProcessingException;

    List<Route> getSubMenu(Long rootId);

    List<Route> getAllRootLevel(Integer rootId);

    List<Route> getPermissions(String routeLink, String roleName);
}
