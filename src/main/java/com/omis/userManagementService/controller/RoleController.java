package com.omis.userManagementService.controller;

import com.omis.userManagementService.models.Category;
import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.request.RoutePermissionRequest;
import com.omis.userManagementService.repository.CategoryRepository;
import com.omis.userManagementService.repository.RolerouteRepository;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.RoleService;
import com.omis.userManagementService.service.RoleRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/user_management")
@CrossOrigin(origins = "*",maxAge = 3600)
public class RoleController {

    private final RoleService roleService;
    private final RoleRouteService roleRouteService;
    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final RolerouteRepository rolerouteRepository;

    @Autowired
    public RoleController(RoleService roleService, RoleRouteService roleRouteService, RouteRepository routeRepository, CategoryRepository categoryRepository, RolerouteRepository rolerouteRepository) {
        this.roleService = roleService;
        this.roleRouteService = roleRouteService;
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.rolerouteRepository = rolerouteRepository;
    }

    //Create Role in Database
    @PostMapping("/roles/{id}/{role-name}/{categoryId}/{status}")
    public boolean saveRole(
            @PathVariable("id") Long id,
            @PathVariable("role-name") String roleName,
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("status") Boolean status
    ) {
        try {
            System.out.printf("id: %d, role-name: %s, categoryId: %d, status: %s%n", id, roleName, categoryId, status);
            return roleService.createRole(id, roleName, status, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Delete a Role
    @DeleteMapping("/deleteRoles/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Long id) {
        try {
            roleService.deleteRole(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Get Role Details
    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            List<Role> roles = roleService.getAllRoles();
            if (roles != null) {
                return ResponseEntity.ok(roles);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Get Category Details
    @GetMapping("/getAllCategoryNames")
    public ResponseEntity<List<Map<String, Object>>> getAllCategoryNames() {
        List<Category> categories = categoryRepository.findAll();
        List<Map<String, Object>> categoryInfoList = new ArrayList<>();

        for (Category category : categories) {
            Map<String, Object> categoryInfo = new HashMap<>();
            categoryInfo.put("id", category.getId());
            categoryInfo.put("categoryName", category.getCategoryName());
            categoryInfoList.add(categoryInfo);
        }

        return ResponseEntity.ok(categoryInfoList);
    }

    /*@GetMapping("/getAllRoutes")
    public ResponseEntity<List<Route>> getAllRoutes() {
        try {
            List<Route> routes = routeRepository.findAll();
            if (routes != null) {
                return ResponseEntity.ok(routes);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/


    @GetMapping("/getAllRouteNames")
    public ResponseEntity<List<Map<String, Object>>> getAllRouteNames() {
        List<Route> routes = routeRepository.findAll();
        List<Map<String, Object>> routeInfoList = new ArrayList<>();

        for (Route route : routes) {
            Map<String, Object> routeInfo = new HashMap<>();
            routeInfo.put("id", route.getId());
            routeInfo.put("RouteName", route.getRouteLink());
            routeInfo.put("category_id", route.getCategoryId());
            routeInfo.put("label", route.getLabel());
            routeInfoList.add(routeInfo);
        }

        return ResponseEntity.ok(routeInfoList);
    }

    @GetMapping("/getAllRolerRouteNames")
    public ResponseEntity<List<Map<String, Object>>> getAllRolerRouteNames() {
        List<Roleroute> roleroutes = rolerouteRepository.findAll();
        List<Map<String, Object>> rolerouteInfoList = new ArrayList<>();

        for (Roleroute roleroute : roleroutes) {
            Map<String, Object> rolerouteInfo = new HashMap<>();
            rolerouteInfo.put("id", roleroute.getId());
            rolerouteInfo.put("roleId", roleroute.getRoleId());
            rolerouteInfo.put("routId", roleroute.getRouteId());
            rolerouteInfo.put("active", roleroute.getActive());
            rolerouteInfo.put("add", roleroute.getAdd());
            rolerouteInfo.put("edit", roleroute.getEdit());
            rolerouteInfo.put("delete", roleroute.getDelete());
            rolerouteInfoList.add(rolerouteInfo);
        }

        return ResponseEntity.ok(rolerouteInfoList);
    }

    @PutMapping("/updateRoles/{id}/{role-name}/{categoryId}/{status}")
    public ResponseEntity<Void> updateRole(
            @PathVariable("id") Long id,
            @PathVariable("role-name") String roleName,
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("status") Boolean status
    ) {
        try {
            boolean updated = roleService.updateRole(id, roleName, status, categoryId);
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

    @PutMapping("/updateRoleRouteAll/{id}/{add}/{edit}/{delete}")
    public ResponseEntity<Void> updateRoleRouteAll(
            @PathVariable("id") Long id,
            @PathVariable("add") Boolean Add,
            @PathVariable("edit") Boolean Edit,
            @PathVariable("delete") Boolean Delete
    ) {
        try {
            boolean updated = roleService.updateRoleRouteAll(id,Add, Edit, Delete);
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

    @PutMapping("/updateRoleRoutesAdd/{id}")
    public ResponseEntity<Void> updateRoleRouteAdd(@RequestBody RoutePermissionRequest request, @PathVariable("id") Long id){
        try {
            boolean updated = roleService.updateRoleRouteAdd(id,request.getAdd());
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

    @PutMapping("/updateRoleRouteEdit/{id}")
    public ResponseEntity<Void> updateRoleRouteEdit(@RequestBody RoutePermissionRequest request, @PathVariable("id") Long id){
        try {
            boolean updated = roleService.updateRoleRouteEdit(id,request.getEdit());
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

    @PutMapping("/updateRoleRouteDelete/{id}")
    public ResponseEntity<Void> updateRoleRouteDelete(@RequestBody RoutePermissionRequest request, @PathVariable("id") Long id){
        try {
            boolean updated = roleService.updateRoleRouteDelete(id,request.getDelete());
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
