package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.entity.RefreshToken;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(Long userId);


    RefreshToken verifyExpiration(
            RefreshToken token
    );


    void deleteByUserId(Long userId);

}
