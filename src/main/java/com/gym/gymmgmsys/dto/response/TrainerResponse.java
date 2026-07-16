package com.gym.gymmgmsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TrainerResponse {

    private Long id;


    private String name;


    private String email;


    private String specialization;


    private Integer experienceYears;


    private Double salary;


    private LocalDate joiningDate;
}
