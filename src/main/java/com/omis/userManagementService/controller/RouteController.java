package com.omis.userManagementService.controller;

import com.omis.userManagementService.payload.request.RoutePermissionRequest;
import com.omis.userManagementService.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "/api/user_management")
@CrossOrigin(origins = "*",maxAge = 3600)
public class RouteController {
    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PutMapping("/updateRoutesAdd/{id}")
    public ResponseEntity<Void> updateRouteAdd(@RequestBody RoutePermissionRequest request, @PathVariable("id") Long id){
        try {
            boolean updated = routeService.updateRouteAdd(id,request.getAdd());
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateRouteEdit/{id}")
    public ResponseEntity<Void> updateRouteEdit(@RequestBody RoutePermissionRequest request, @PathVariable("id") Long id){
        try {
            boolean updated = routeService.updateRouteEdit(id,request.getEdit());
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateRoutesDelete/{id}")
    public ResponseEntity<Void> updateRouteDelete(@RequestBody RoutePermissionRequest request, @PathVariable("id") Long id){
        try {
            boolean updated = routeService.updateRouteDelete(id,request.getDelete());
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateRouteAll/{id}/{add}/{edit}/{delete}")
    public ResponseEntity<Void> updateRouteAll(
            @PathVariable("id") Long id,
            @PathVariable("add") Boolean Add,
            @PathVariable("edit") Boolean Edit,
            @PathVariable("delete") Boolean Delete
    ) {
        try {
            boolean updated = routeService.updateRouteAll(id,Add, Edit, Delete);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }




    }





}
