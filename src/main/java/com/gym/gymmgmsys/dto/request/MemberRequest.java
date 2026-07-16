package com.gym.gymmgmsys.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequest {

    @NotNull
    private Integer age;


    private String gender;


    private Double height;


    private Double weight;


    private String address;

}
