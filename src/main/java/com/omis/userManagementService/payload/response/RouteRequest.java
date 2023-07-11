package com.omis.userManagementService.payload.response;

import com.omis.userManagementService.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    private Long id;
    private String routeLink;
    private Long categoryId;
    private Boolean active = false;
}

