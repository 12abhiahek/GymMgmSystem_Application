package com.gym.gymmgmsys.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembershipPlanRequest {

    private String name;


    private String description;


    private Integer durationMonths;


    private Double price;

}
