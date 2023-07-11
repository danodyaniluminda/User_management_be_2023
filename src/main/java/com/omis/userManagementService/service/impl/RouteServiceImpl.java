package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Category;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.RouteRequest;
import com.omis.userManagementService.payload.response.RouteResponse;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.CategoryService;
import com.omis.userManagementService.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {



    @Autowired
    RouteRepository routeRepository;

    @Autowired
    CategoryService categoryService;

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

    @Override
    public String addNewRoute(RouteRequest routeRequest) {
        try {
            Route route = new Route();
            route.setRouteLink(routeRequest.getRouteLink());
            Category category = categoryService.findById(routeRequest.getCategoryId());
            if(category==null){
                return "error : No value present for category ID : " + routeRequest.getCategoryId().toString();
            }
            route.setCategoryId(category);
            route.setActive(routeRequest.getActive());
            route = routeRepository.save(route);
            return "success : New Route with ID (" + route.getId().toString() + ") created successfully";
        }catch (Error e){
            return "error : " + e.getLocalizedMessage();
        }

    }

    @Override
    public String updateRoute(Route route) {
        try{
            routeRepository.save(route);
            return "success : Route with ID (" + route.getId().toString() + ") updated successfully";
        }catch (Error e){
            return "error : " + e.getLocalizedMessage();
        }
    }

    @Override
    public String archiveRoute(Long id) {
        try{
            Route route = routeRepository.findById(id).orElseThrow();
            //Set archive false
            //route.setActive(false);
            routeRepository.save(route);
            return "success : ";
        }catch (Error e){
            return "error : " + e.getLocalizedMessage();
        }
    }
}
