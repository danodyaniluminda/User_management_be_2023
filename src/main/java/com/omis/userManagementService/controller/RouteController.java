package com.omis.userManagementService.controller;

import com.omis.userManagementService.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/routes")
public class RouteController {

    @Autowired
    RouteService routeService;

    @GetMapping(value ="/get_all_routes")
    public ResponseEntity<?> getAllRoutes(){
        return ResponseEntity.ok().body(routeService.getAllRoutes());
    }


}
