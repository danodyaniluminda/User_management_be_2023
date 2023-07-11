package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Category;
import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.repository.CategoryRepository;
import com.omis.userManagementService.repository.RoleRepository;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RouteRepository routeRepository, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean createRole(Long id, String roleName, boolean status, Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            if (category == null) {
                System.out.println("Category not found");
                return false;
            }
            Role role = new Role();
            role.setRoleName(roleName);
            role.setActive(status);
            role.setCategoryId(category);
            roleRepository.save(role);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }



    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public boolean updateRole(Long id, String roleName, Boolean status, Long categoryId) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setRoleName(roleName);
            role.setActive(status);
            role.setCategory(categoryRepository.findById(categoryId).orElse(null));
            roleRepository.save(role);
            return true;
        } else {
            return false;
        }
    }


}







