package com.omis.userManagementService.repository;

import com.omis.userManagementService.models.Role;
import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RolerouteRepository extends JpaRepository<Roleroute, Long> {
    List<Roleroute> findRolerouteByRoleIdAndActive(Optional<Role> role, Boolean b);
}