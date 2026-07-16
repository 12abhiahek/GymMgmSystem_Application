package com.gym.gymmgmsys.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerRequest {
    @NotBlank
    private String specialization;


    private Integer experienceYears;


    private Double salary;

}
