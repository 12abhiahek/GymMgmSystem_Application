package com.gym.gymmgmsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AttendanceResponse {


    private Long id;


    private String memberName;


    private LocalDate attendanceDate;


    private LocalDateTime checkInTime;


    private LocalDateTime checkOutTime;


    private String status;
}
