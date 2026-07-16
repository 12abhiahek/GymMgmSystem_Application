package com.gym.gymmgmsys.service;

import com.gym.gymmgmsys.dto.request.TrainerRequest;
import com.gym.gymmgmsys.dto.response.TrainerResponse;

import java.util.List;

public interface TrainerService {

    TrainerResponse create(
            Long userId,
            TrainerRequest request
    );



    TrainerResponse getById(
            Long id
    );



    List<TrainerResponse> getAll();



    TrainerResponse update(
            Long id,
            TrainerRequest request
    );



    void delete(
            Long id
    );

}
