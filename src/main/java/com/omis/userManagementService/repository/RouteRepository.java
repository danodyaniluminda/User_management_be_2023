package com.omis.userManagementService.repository;

import com.omis.userManagementService.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
//    List<Route> findAllByActiveAndParent(Boolean b, Optional<Route> route);
}