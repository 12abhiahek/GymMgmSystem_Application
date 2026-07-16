package com.gym.gymmgmsys.controller;


import com.gym.gymmgmsys.dto.request.CheckInRequest;
import com.gym.gymmgmsys.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
public class AttendanceController {



    private final AttendanceService attendanceService;




    @PostMapping("/check-in")
    @PreAuthorize(
            "hasAnyRole('ADMIN','RECEPTIONIST','MEMBER')"
    )
    public ResponseEntity<?> checkIn(
            @RequestBody CheckInRequest request
    ){


        return ResponseEntity.ok(
                attendanceService.checkIn(request)
        );

    }





    @PutMapping("/check-out/{memberId}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','RECEPTIONIST','MEMBER')"
    )
    public ResponseEntity<?> checkOut(
            @PathVariable Long memberId
    ){


        return ResponseEntity.ok(
                attendanceService.checkOut(memberId)
        );

    }





    @GetMapping("/member/{memberId}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','TRAINER','MEMBER')"
    )
    public ResponseEntity<?> history(
            @PathVariable Long memberId
    ){


        return ResponseEntity.ok(
                attendanceService
                        .getMemberHistory(memberId)
        );

    }





    @GetMapping("/today")
    @PreAuthorize(
            "hasAnyRole('ADMIN','TRAINER')"
    )
    public ResponseEntity<?> today(){


        return ResponseEntity.ok(
                attendanceService
                        .getTodayAttendance()
        );

    }


}