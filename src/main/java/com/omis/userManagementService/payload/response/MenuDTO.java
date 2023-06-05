package com.omis.userManagementService.payload.response;

import com.omis.userManagementService.models.Roleroute;
import lombok.Data;

import java.util.Set;
@Data
public class MenuDTO {
    private String routeLink;
    private String icon;
    private String label;
    private Set<Roleroute> items;



}
