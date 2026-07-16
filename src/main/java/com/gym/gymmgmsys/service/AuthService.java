package com.gym.gymmgmsys.service;

import com.gym.gymmgmsys.dto.request.LoginRequest;
import com.gym.gymmgmsys.dto.request.RefreshTokenRequest;
import com.gym.gymmgmsys.dto.request.RegisterRequest;
import com.gym.gymmgmsys.dto.response.AuthResponse;
import com.gym.gymmgmsys.dto.response.TokenResponse;

public interface AuthService {


    AuthResponse register(
            RegisterRequest request
    );


    AuthResponse login(
            LoginRequest request
    );

    TokenResponse refreshToken(
            RefreshTokenRequest request
    );


    void logout(Long userId);



}
