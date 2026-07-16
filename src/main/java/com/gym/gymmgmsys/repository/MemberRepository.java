package com.gym.gymmgmsys.repository;

import com.gym.gymmgmsys.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByUserId(
            Long userId
    );
}
