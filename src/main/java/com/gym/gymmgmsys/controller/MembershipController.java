package com.gym.gymmgmsys.controller;

import com.gym.gymmgmsys.dto.request.AssignMembershipRequest;
import com.gym.gymmgmsys.dto.request.MembershipPlanRequest;
import com.gym.gymmgmsys.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/membership")
public class MembershipController {


        private final MembershipService membershipService;




        @PostMapping("/plans")
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<?> createPlan(
                @RequestBody MembershipPlanRequest request
        ){

            return ResponseEntity.ok(
                    membershipService.createPlan(request)
            );

        }





        @GetMapping("/plans")
        public ResponseEntity<?> plans(){

            return ResponseEntity.ok(
                    membershipService.getPlans()
            );

        }





        @PostMapping("/assign")
        @PreAuthorize(
                "hasAnyRole('ADMIN','RECEPTIONIST')"
        )
        public ResponseEntity<?> assign(
                @RequestBody AssignMembershipRequest request
        ){

            return ResponseEntity.ok(
                    membershipService.assignPlan(request)
            );

        }





        @GetMapping("/member/{memberId}")
        public ResponseEntity<?> memberSubscription(
                @PathVariable Long memberId
        ){

            return ResponseEntity.ok(
                    membershipService
                            .getMemberSubscription(memberId)
            );

        }

    }
