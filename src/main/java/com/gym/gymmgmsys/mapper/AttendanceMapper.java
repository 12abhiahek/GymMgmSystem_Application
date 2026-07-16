package com.gym.gymmgmsys.mapper;

import com.gym.gymmgmsys.dto.response.AttendanceResponse;
import com.gym.gymmgmsys.entity.Attendance;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {


        public AttendanceResponse toResponse(
                Attendance attendance
        ){


            return AttendanceResponse.builder()

                    .id(
                            attendance.getId()
                    )

                    .memberName(
                            attendance.getMember()
                                    .getUser()
                                    .getFirstName()
                    )

                    .attendanceDate(
                            attendance.getAttendanceDate()
                    )

                    .checkInTime(
                            attendance.getCheckInTime()
                    )

                    .checkOutTime(
                            attendance.getCheckOutTime()
                    )

                    .status(
                            attendance.getStatus()
                                    .name()
                    )

                    .build();

        }

    }
