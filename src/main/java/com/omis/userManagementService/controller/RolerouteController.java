package com.omis.userManagementService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.repository.RoleRepository;
import com.omis.userManagementService.service.RoleRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user_management/menu")
public class RolerouteController {

    @Autowired
    RoleRouteService roleRouteService;

    @Autowired
    RoleRepository roleRepository;

    Logger logger = LoggerFactory.getLogger(RolerouteController.class);

    @GetMapping(value = "/getMenu")
    public List<Route> getAllCountries() throws JsonProcessingException {
        return roleRouteService.getAll(roleRepository.findById(1L));
//        return  roleRouteService.getAllRootLevel(null);
    }

    @GetMapping(value = "/getRoot")
    public List<Route> getRoot(){return  roleRouteService.getAllRootLevel(null);}

    @GetMapping("/get_menu_by_root_id")
    public List<Route> getMenuByRootId(@RequestParam(name = "rootId") Long rootId) {
        try {
            return roleRouteService.getSubMenu(rootId);
        } catch (Exception e) {
            logger.error(e.getMessage());
//            return ResponseEntity.badRequest().body("error : Record does not exists with provided primary key or composite key.");
        }
        return null;
    }

    @GetMapping("/get_permissions")
    public List<Route> getPermissions(@RequestParam(name = "role_name") String roleName) {
        try {
            return roleRouteService.getPermissions(null,roleName);
        } catch (Exception e) {
            logger.error(e.getMessage());
//            return ResponseEntity.badRequest().body("error : Record does not exists with provided primary key or composite key.");
        }
        return null;
    }

}
