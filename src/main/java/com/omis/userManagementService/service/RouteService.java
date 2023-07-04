package com.omis.userManagementService.service;

import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.RouteResponse;

import java.util.List;

public interface RouteService {
    List<Route> getAllRoutes();
    List<RouteResponse> getAllRouteResponse();
}
