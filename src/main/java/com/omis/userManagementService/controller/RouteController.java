package com.omis.userManagementService.controller;

import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.RouteRequest;
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

    @PostMapping("/add_new_route")
    public ResponseEntity<?> addNewRoute(@RequestBody RouteRequest routeRequest){
        System.out.println("Line 31");
        String response = routeService.addNewRoute(routeRequest);
        if(response.toLowerCase().startsWith("success")){
            return ResponseEntity.ok().body(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/update_route")
    public ResponseEntity<?> updateRoute(@RequestBody Route route){

        String response = routeService.updateRoute(route);


        if(response.toLowerCase().startsWith("success")){
            return ResponseEntity.ok().body(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/archive_route")
    public ResponseEntity<?> archiveRoute(@RequestParam Long id){
        String response = routeService.archiveRoute(id);
        System.out.println("response : "+ response);
        if(response.toLowerCase().startsWith("success")){
            return ResponseEntity.ok().body(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }



}
