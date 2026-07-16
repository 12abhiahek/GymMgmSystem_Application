package com.gym.gymmgmsys.service;

import com.gym.gymmgmsys.dto.request.CheckInRequest;
import com.gym.gymmgmsys.dto.response.AttendanceResponse;

import java.util.List;

public interface AttendanceService {

    AttendanceResponse checkIn(
            CheckInRequest request
    );



    AttendanceResponse checkOut(
            Long memberId
    );



    List<AttendanceResponse> getMemberHistory(
            Long memberId
    );



    List<AttendanceResponse> getTodayAttendance();

}
