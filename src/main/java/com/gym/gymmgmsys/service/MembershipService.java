package com.gym.gymmgmsys.service;

import com.gym.gymmgmsys.dto.request.AssignMembershipRequest;
import com.gym.gymmgmsys.dto.request.MembershipPlanRequest;
import com.gym.gymmgmsys.dto.response.MemberSubscriptionResponse;
import com.gym.gymmgmsys.dto.response.MembershipPlanResponse;

import java.util.List;

public interface MembershipService {


    MembershipPlanResponse createPlan(
            MembershipPlanRequest request
    );



    List<MembershipPlanResponse> getPlans();



    MemberSubscriptionResponse assignPlan(
            AssignMembershipRequest request
    );



    MemberSubscriptionResponse getMemberSubscription(
            Long memberId
    );
}
