package com.gym.gymmgmsys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "membership_plans")
public class MembershipPlan extends BaseAuditEntity{
    private String name;


    private String description;


    private Integer durationMonths;


    private Double price;


    private boolean active = true;

}
