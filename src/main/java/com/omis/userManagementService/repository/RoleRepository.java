package com.omis.userManagementService.repository;

import com.omis.userManagementService.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}