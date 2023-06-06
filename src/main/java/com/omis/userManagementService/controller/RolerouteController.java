package com.omis.userManagementService.controller;

import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.MenuDTO;
import com.omis.userManagementService.service.RoleRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user_management/menu")
public class RolerouteController {

    @Autowired
    RoleRouteService roleRouteService;

    @GetMapping(value = "/getMenu")
    public List<Route> getAllCountries() {
        return roleRouteService.getAll();
    }

}
