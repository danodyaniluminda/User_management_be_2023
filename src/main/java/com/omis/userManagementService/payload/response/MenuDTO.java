package com.omis.userManagementService.payload.response;

import com.omis.userManagementService.models.Roleroute;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Set;
@Data
@NoArgsConstructor
public class MenuDTO {
    private String routeLink;
    private String icon;
    private String label;
    private Set<MenuDTO> items;

}
