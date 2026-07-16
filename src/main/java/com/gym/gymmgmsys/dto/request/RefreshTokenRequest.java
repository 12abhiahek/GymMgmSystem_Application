package com.gym.gymmgmsys.dto.request;

import com.gym.gymmgmsys.entity.RefreshToken;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RefreshTokenRequest {

    @NotBlank
    private String refreshToken;
}
