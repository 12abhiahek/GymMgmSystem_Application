package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.dto.request.TrainerRequest;
import com.gym.gymmgmsys.dto.response.TrainerResponse;
import com.gym.gymmgmsys.entity.Trainer;
import com.gym.gymmgmsys.entity.User;
import com.gym.gymmgmsys.mapper.TrainerMapper;
import com.gym.gymmgmsys.repository.TrainerRepository;
import com.gym.gymmgmsys.repository.UserRepository;
import com.gym.gymmgmsys.service.TrainerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

        private final TrainerRepository trainerRepository;


        private final UserRepository userRepository;


        private final TrainerMapper mapper;

    public TrainerServiceImpl(TrainerRepository trainerRepository, UserRepository userRepository, TrainerMapper mapper) {
        this.trainerRepository = trainerRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
        public TrainerResponse create(
                Long userId,
                TrainerRequest request
        ){


            User user =
                    userRepository.findById(userId)
                            .orElseThrow();



            Trainer trainer =
                    new Trainer();



            trainer.setUser(user);



            trainer.setSpecialization(
                    request.getSpecialization()
            );



            trainer.setExperienceYears(
                    request.getExperienceYears()
            );



            trainer.setSalary(
                    request.getSalary()
            );



            trainer.setJoiningDate(
                    LocalDate.now()
            );



            return mapper.toResponse(
                    trainerRepository.save(trainer)
            );

        }




        @Override
        public TrainerResponse getById(Long id){


            return trainerRepository.findById(id)

                    .map(mapper::toResponse)

                    .orElseThrow();

        }





        @Override
        public List<TrainerResponse> getAll(){


            return trainerRepository.findAll()

                    .stream()

                    .map(mapper::toResponse)

                    .toList();

        }





        @Override
        public TrainerResponse update(
                Long id,
                TrainerRequest request
        ){


            Trainer trainer =
                    trainerRepository.findById(id)
                            .orElseThrow();



            trainer.setSpecialization(
                    request.getSpecialization()
            );


            trainer.setExperienceYears(
                    request.getExperienceYears()
            );


            trainer.setSalary(
                    request.getSalary()
            );



            return mapper.toResponse(
                    trainerRepository.save(trainer)
            );

        }





        @Override
        public void delete(Long id){

            trainerRepository.deleteById(id);

        }

    }
