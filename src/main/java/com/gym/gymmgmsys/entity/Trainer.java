package com.gym.gymmgmsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="trainers")
@Getter
@Setter
public class Trainer extends BaseAuditEntity{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="user_id",
            nullable=false
    )
    private User user;



    private String specialization;



    private Integer experienceYears;



    private Double salary;



    private LocalDate joiningDate;


}
