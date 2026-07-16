package com.gym.gymmgmsys.repository;

import com.gym.gymmgmsys.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    Optional<Attendance>
    findByMemberIdAndAttendanceDate(
            Long memberId,
            LocalDate date
    );



    List<Attendance>
    findByMemberIdOrderByAttendanceDateDesc(
            Long memberId
    );
}
