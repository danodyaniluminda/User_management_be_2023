package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.repository.RolerouteRepository;
import com.omis.userManagementService.service.RoleRouteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleRouteServiceImpl implements RoleRouteService {

    @Autowired
    private RolerouteRepository rolerouteRepository;

    @Override
    public List<Roleroute> getAll() {

        return rolerouteRepository.findAll().stream()
                .filter(menu-> Objects.isNull(menu.getParent()))
                .collect(Collectors.toList());

    }
}
