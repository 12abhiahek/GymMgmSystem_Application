package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.dto.request.CheckInRequest;
import com.gym.gymmgmsys.dto.response.AttendanceResponse;
import com.gym.gymmgmsys.entity.Attendance;
import com.gym.gymmgmsys.entity.AttendanceStatus;
import com.gym.gymmgmsys.entity.Member;
import com.gym.gymmgmsys.mapper.AttendanceMapper;
import com.gym.gymmgmsys.repository.AttendanceRepository;
import com.gym.gymmgmsys.repository.MemberRepository;
import com.gym.gymmgmsys.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {



        private final AttendanceRepository attendanceRepository;


        private final MemberRepository memberRepository;


        private final AttendanceMapper mapper;




        @Override
        public AttendanceResponse checkIn(
                CheckInRequest request
        ){


            Member member =
                    memberRepository.findById(
                                    request.getMemberId()
                            )
                            .orElseThrow();



            attendanceRepository
                    .findByMemberIdAndAttendanceDate(
                            member.getId(),
                            LocalDate.now()
                    )
                    .ifPresent(
                            a -> {
                                throw new RuntimeException(
                                        "Already checked in"
                                );
                            }
                    );



            Attendance attendance =
                    new Attendance();


            attendance.setMember(member);


            attendance.setAttendanceDate(
                    LocalDate.now()
            );


            attendance.setCheckInTime(
                    LocalDateTime.now()
            );


            attendance.setStatus(
                    AttendanceStatus.PRESENT
            );



            return mapper.toResponse(
                    attendanceRepository.save(attendance)
            );

        }





        @Override
        public AttendanceResponse checkOut(
                Long memberId
        ){


            Attendance attendance =
                    attendanceRepository
                            .findByMemberIdAndAttendanceDate(
                                    memberId,
                                    LocalDate.now()
                            )
                            .orElseThrow();



            attendance.setCheckOutTime(
                    LocalDateTime.now()
            );



            return mapper.toResponse(
                    attendanceRepository.save(attendance)
            );

        }





        @Override
        public List<AttendanceResponse> getMemberHistory(
                Long memberId
        ){


            return attendanceRepository
                    .findByMemberIdOrderByAttendanceDateDesc(
                            memberId
                    )

                    .stream()

                    .map(mapper::toResponse)

                    .toList();

        }





        @Override
        public List<AttendanceResponse> getTodayAttendance(){


            return attendanceRepository.findAll()

                    .stream()

                    .filter(
                            a ->
                                    a.getAttendanceDate()
                                            .equals(LocalDate.now())
                    )

                    .map(mapper::toResponse)

                    .toList();

        }


}
