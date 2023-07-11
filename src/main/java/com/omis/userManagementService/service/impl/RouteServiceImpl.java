package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public boolean updateRouteAdd(Long id, Boolean add) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setAdd(add != null && add);
            routeRepository.save(route);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean updateRouteEdit(Long id, Boolean edit) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setEdit(edit != null && edit);
            routeRepository.save(route);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateRouteDelete(Long id, Boolean delete) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setDelete(delete != null && delete);
            routeRepository.save(route);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean updateRouteAll(Long id, Boolean add, Boolean edit,Boolean delete ) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setAdd(add != null && add);
            route.setEdit(edit != null && edit);
            route.setDelete(delete != null && delete);
            routeRepository.save(route);
            return true;
        } else {
            return false;
        }
    }
}
