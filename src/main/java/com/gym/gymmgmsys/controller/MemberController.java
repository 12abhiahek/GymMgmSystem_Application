package com.gym.gymmgmsys.controller;

import com.gym.gymmgmsys.dto.request.MemberRequest;
import com.gym.gymmgmsys.dto.response.MemberResponse;
import com.gym.gymmgmsys.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {



    private final MemberService memberService;



    @PostMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MemberResponse> create(
            @PathVariable Long userId,
            @Valid @RequestBody MemberRequest request
    ){

        return ResponseEntity.ok(
                memberService.create(
                        userId,
                        request
                )
        );

    }




    @GetMapping("/{id}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','TRAINER','MEMBER')"
    )
    public ResponseEntity<MemberResponse> get(
            @PathVariable Long id
    ){

        return ResponseEntity.ok(
                memberService.getById(id)
        );

    }




    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(
                memberService.getAll()
        );

    }




    @PutMapping("/{id}")
    @PreAuthorize(
            "hasAnyRole('ADMIN','MEMBER')"
    )
    public ResponseEntity<MemberResponse> update(
            @PathVariable Long id,
            @RequestBody MemberRequest request
    ){

        return ResponseEntity.ok(
                memberService.update(
                        id,
                        request
                )
        );

    }




    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ){

        memberService.delete(id);

        return ResponseEntity.ok(
                "Member deleted"
        );

    }

}