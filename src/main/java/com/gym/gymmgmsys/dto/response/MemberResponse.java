package com.gym.gymmgmsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MemberResponse {

    private Long id;


    private String name;


    private String email;


    private Integer age;


    private String gender;


    private Double height;


    private Double weight;


    private String address;


    private LocalDate joinDate;

}
