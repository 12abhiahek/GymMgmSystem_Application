package com.gym.gymmgmsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MembershipPlanResponse {

    private Long id;


    private String name;


    private String description;


    private Integer durationMonths;


    private Double price;


    private boolean active;


}
