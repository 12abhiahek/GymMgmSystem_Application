package com.gym.gymmgmsys.mapper;

import com.gym.gymmgmsys.dto.response.TrainerResponse;
import com.gym.gymmgmsys.entity.Trainer;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {

        public TrainerResponse toResponse(
                Trainer trainer
        ){


            return TrainerResponse.builder()

                    .id(
                            trainer.getId()
                    )

                    .name(
                            trainer.getUser()
                                    .getFirstName()
                                    +" "
                                    +trainer.getUser()
                                    .getLastName()
                    )

                    .email(
                            trainer.getUser()
                                    .getEmail()
                    )


                    .specialization(
                            trainer.getSpecialization()
                    )


                    .experienceYears(
                            trainer.getExperienceYears()
                    )


                    .salary(
                            trainer.getSalary()
                    )


                    .joiningDate(
                            trainer.getJoiningDate()
                    )

                    .build();

        }

    }
