package com.gym.gymmgmsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MemberSubscriptionResponse {

    private Long id;


    private String memberName;


    private String planName;


    private LocalDate startDate;


    private LocalDate endDate;


    private String status;

}
