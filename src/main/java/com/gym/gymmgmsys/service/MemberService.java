package com.gym.gymmgmsys.service;

import com.gym.gymmgmsys.dto.request.MemberRequest;
import com.gym.gymmgmsys.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {

    MemberResponse create(
            Long userId,
            MemberRequest request
    );



    MemberResponse getById(
            Long id
    );



    List<MemberResponse> getAll();



    MemberResponse update(
            Long id,
            MemberRequest request
    );



    void delete(
            Long id
    );
}
