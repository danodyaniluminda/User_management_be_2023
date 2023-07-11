package com.omis.userManagementService.repository;

import com.omis.userManagementService.models.Category;
import com.omis.userManagementService.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findById(Long id);
}