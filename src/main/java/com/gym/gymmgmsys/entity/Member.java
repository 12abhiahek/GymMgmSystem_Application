package com.gym.gymmgmsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="members")
@Getter
@Setter
public class Member extends BaseAuditEntity{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="user_id",
            nullable=false
    )
    private User user;



    private Integer age;


    private String gender;


    private Double height;


    private Double weight;


    private String address;



    private LocalDate joinDate;


}
