package com.gym.gymmgmsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class TokenResponse {

    private String accessToken;


    private String refreshToken;


    private String tokenType;

}
