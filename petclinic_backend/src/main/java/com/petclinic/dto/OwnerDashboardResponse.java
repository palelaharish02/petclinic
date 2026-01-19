package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OwnerDashboardResponse {

    private Long ownerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String dashboardMessage;
}
