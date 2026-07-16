package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.dto.request.AssignMembershipRequest;
import com.gym.gymmgmsys.dto.request.MembershipPlanRequest;
import com.gym.gymmgmsys.dto.response.MemberSubscriptionResponse;
import com.gym.gymmgmsys.dto.response.MembershipPlanResponse;
import com.gym.gymmgmsys.entity.Member;
import com.gym.gymmgmsys.entity.MemberSubscription;
import com.gym.gymmgmsys.entity.MembershipPlan;
import com.gym.gymmgmsys.entity.SubscriptionStatus;
import com.gym.gymmgmsys.repository.MemberRepository;
import com.gym.gymmgmsys.repository.MemberSubscriptionRepository;
import com.gym.gymmgmsys.repository.MembershipPlanRepository;
import com.gym.gymmgmsys.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {



        private final MembershipPlanRepository planRepository;


        private final MemberSubscriptionRepository subscriptionRepository;


        private final MemberRepository memberRepository;



        @Override
        public MembershipPlanResponse createPlan(
                MembershipPlanRequest request
        ){


            MembershipPlan plan =
                    new MembershipPlan();


            plan.setName(
                    request.getName()
            );


            plan.setDescription(
                    request.getDescription()
            );


            plan.setDurationMonths(
                    request.getDurationMonths()
            );


            plan.setPrice(
                    request.getPrice()
            );


            return mapPlan(
                    planRepository.save(plan)
            );

        }




        @Override
        public List<MembershipPlanResponse> getPlans(){

            return planRepository.findAll()
                    .stream()
                    .map(this::mapPlan)
                    .toList();

        }




        @Override
        public MemberSubscriptionResponse assignPlan(
                AssignMembershipRequest request
        ){


            Member member =
                    memberRepository.findById(
                                    request.getMemberId()
                            )
                            .orElseThrow();



            MembershipPlan plan =
                    planRepository.findById(
                                    request.getPlanId()
                            )
                            .orElseThrow();



            MemberSubscription subscription =
                    new MemberSubscription();


            subscription.setMember(member);


            subscription.setPlan(plan);


            subscription.setStartDate(
                    LocalDate.now()
            );


            subscription.setEndDate(
                    LocalDate.now()
                            .plusMonths(
                                    plan.getDurationMonths()
                            )
            );


            subscription.setStatus(
                    SubscriptionStatus.ACTIVE
            );


            return mapSubscription(
                    subscriptionRepository.save(subscription)
            );

        }





        @Override
        public MemberSubscriptionResponse getMemberSubscription(
                Long memberId
        ){


            return subscriptionRepository
                    .findFirstByMemberIdOrderByEndDateDesc(memberId)

                    .map(this::mapSubscription)

                    .orElseThrow();

        }






        private MembershipPlanResponse mapPlan(
                MembershipPlan plan
        ){

            return MembershipPlanResponse.builder()

                    .id(plan.getId())

                    .name(plan.getName())

                    .description(plan.getDescription())

                    .durationMonths(
                            plan.getDurationMonths()
                    )

                    .price(plan.getPrice())

                    .active(plan.isActive())

                    .build();

        }





        private MemberSubscriptionResponse mapSubscription(
                MemberSubscription subscription
        ){

            return MemberSubscriptionResponse.builder()

                    .id(subscription.getId())

                    .memberName(
                            subscription.getMember()
                                    .getUser()
                                    .getFirstName()
                    )

                    .planName(
                            subscription.getPlan()
                                    .getName()
                    )

                    .startDate(
                            subscription.getStartDate()
                    )

                    .endDate(
                            subscription.getEndDate()
                    )

                    .status(
                            subscription.getStatus()
                                    .name()
                    )

                    .build();

        }

    }
