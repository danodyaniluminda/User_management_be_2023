package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Roleroute;
import com.omis.userManagementService.models.Route;
import com.omis.userManagementService.payload.response.MenuDTO;
import com.omis.userManagementService.repository.RolerouteRepository;
import com.omis.userManagementService.repository.RouteRepository;
import com.omis.userManagementService.service.RoleRouteService;
import com.omis.userManagementService.utils.ObjectMapperUtils;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleRouteServiceImpl implements RoleRouteService {

    @Autowired
    private RolerouteRepository rolerouteRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getAll() {

        List<Route> allMenu = routeRepository.findAll().stream()
                .filter(menu -> Objects.isNull(menu.getParent()))
                .toList();
//        List<MenuDTO> menuDTOList = new ArrayList<>();
//        for (Roleroute roleroute : allMenu) {
//            MenuDTO menuDTO = new MenuDTO();
//            menuDTO.setRouteLink(roleroute.getRouteId().getRouteName());
//            menuDTO.setLabel(roleroute.getRouteId().getLabel());
////            menuDTO.setItems(roleroute.getItems());
//
//            for (Roleroute rolerouteItems : roleroute.getItems()) {
//                MenuDTO menuDTO1 = new MenuDTO();
//                menuDTO1.setRouteLink(rolerouteItems.getRouteId().getRouteName());
//                menuDTO1.setLabel(rolerouteItems.getRouteId().getLabel());
////                menuDTO.setItems();
//            }
//            menuDTOList.add(menuDTO);
//        }
//        return ObjectMapperUtils.mapAll(allMenu,MenuDTO.class);
        return allMenu;

    }
}
