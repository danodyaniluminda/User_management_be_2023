package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.repository.RolerouteRepository;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.RoleRouteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class RoleRouteServiceImpl implements RoleRouteService {

    @Autowired
    private RolerouteRepository rolerouteRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getAll(Optional<Role> role) {
        List<Roleroute> roleroutesByRole = rolerouteRepository.findRolerouteByRoleIdAndActive(role,true);
        ArrayList<Route> routeArrayList = new ArrayList<>();
        for(Roleroute item : roleroutesByRole){
            routeArrayList.add(item.getRouteId());
        }
        List<Route> routes = routeArrayList.stream()
                .filter(menu -> Objects.isNull(menu.getParent()))
                .toList();
//        routes.stream().filter()
//        for (Route route : routes){
//            Set<Route> routeList = route.getItems();
//        }
        return routes;

    }

    @Override
    public List<Route> getSubMenu(Long rootId) {
        return routeRepository.findAllByActiveAndParent(true,routeRepository.findById(rootId));
    }

    @Override
    public List<Route> getAllRootLevel(Integer rootId) {
        return routeRepository.findAllByActiveAndParent(true,null);

    }

//    @Override
//    public List<Route> getAllRootLevel(Integer rootId){
//        return routeRepository.findAllByActiveAndParent(true,null);
//    }

}
