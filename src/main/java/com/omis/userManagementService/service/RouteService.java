package com.omis.userManagementService.service;

import com.omis.userManagementService.models.Route;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RouteService {
    List<Route> getAllRoutes();

    boolean updateRouteEdit(Long id, Boolean edit);

    boolean updateRouteDelete(Long id, Boolean delete);

    boolean updateRouteAdd(Long id, Boolean add);


    boolean updateRouteAll(Long id, Boolean add, Boolean edit, Boolean delete);
}
