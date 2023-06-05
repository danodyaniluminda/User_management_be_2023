package com.omis.userManagementService.repository;

import com.omis.userManagementService.models.Roleroute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolerouteRepository extends JpaRepository<Roleroute, Long> {
}