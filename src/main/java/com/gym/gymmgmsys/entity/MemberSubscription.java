package com.gym.gymmgmsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "member_subscriptions")
@Getter
@Setter
public class MemberSubscription extends BaseAuditEntity{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="plan_id")
    private MembershipPlan plan;



    private LocalDate startDate;


    private LocalDate endDate;



    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;


}
