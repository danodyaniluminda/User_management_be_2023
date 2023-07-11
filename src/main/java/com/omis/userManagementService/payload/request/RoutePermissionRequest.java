package com.omis.userManagementService.payload.request;

import lombok.Data;

@Data
public class RoutePermissionRequest {
    Boolean add;
    Boolean edit;
    Boolean delete;
}
