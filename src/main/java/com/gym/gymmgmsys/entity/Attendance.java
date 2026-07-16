package com.gym.gymmgmsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "attendance")
@Entity
public class Attendance extends BaseAuditEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="member_id",
            nullable=false
    )
    private Member member;



    private LocalDate attendanceDate;



    private LocalDateTime checkInTime;



    private LocalDateTime checkOutTime;



    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;


}
