package com.gym.gymmgmsys.repository;

import com.gym.gymmgmsys.entity.MembershipPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipPlanRepository extends JpaRepository<MembershipPlan,Long> {
}
