package com.omis.userManagementService.service;

import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.MenuDTO;

import java.util.List;

public interface RoleRouteService {
    List<Route> getAll();
}
