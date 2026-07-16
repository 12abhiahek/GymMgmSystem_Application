package com.gym.gymmgmsys.controller;

import com.gym.gymmgmsys.dto.request.TrainerRequest;
import com.gym.gymmgmsys.dto.response.TrainerResponse;
import com.gym.gymmgmsys.service.TrainerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trainers")
public class TrainerController {

        private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @PostMapping("/{userId}")
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<TrainerResponse> create(
                @PathVariable Long userId,
                @Valid @RequestBody TrainerRequest request
        ){


            return ResponseEntity.ok(

                    trainerService.create(
                            userId,
                            request
                    )

            );

        }




        @GetMapping("/{id}")
        @PreAuthorize(
                "hasAnyRole('ADMIN','TRAINER')"
        )
        public ResponseEntity<TrainerResponse> get(
                @PathVariable Long id
        ){


            return ResponseEntity.ok(

                    trainerService.getById(id)

            );

        }




        @GetMapping
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<?> getAll(){


            return ResponseEntity.ok(

                    trainerService.getAll()

            );

        }




        @PutMapping("/{id}")
        @PreAuthorize(
                "hasAnyRole('ADMIN','TRAINER')"
        )
        public ResponseEntity<TrainerResponse> update(
                @PathVariable Long id,
                @RequestBody TrainerRequest request
        ){


            return ResponseEntity.ok(

                    trainerService.update(
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


            trainerService.delete(id);


            return ResponseEntity.ok(
                    "Trainer deleted"
            );

        }

    }
