package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.RouteResponse;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public List<RouteResponse> getAllRouteResponse() {
        List<Route> routes = routeRepository.findAll();
        List<RouteResponse> routeResponseList = new ArrayList<>();
        for (int i = 0; i < routes.size(); i++) {
            routeResponseList.add(new RouteResponse());
        }
        return routeResponseList;
    }
}
