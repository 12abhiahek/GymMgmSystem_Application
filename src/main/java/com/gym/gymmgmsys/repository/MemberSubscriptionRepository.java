package com.gym.gymmgmsys.repository;

import com.gym.gymmgmsys.entity.MemberSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberSubscriptionRepository extends JpaRepository<MemberSubscription,Long> {


    Optional<MemberSubscription>
    findFirstByMemberIdOrderByEndDateDesc(
            Long memberId
    );
}
