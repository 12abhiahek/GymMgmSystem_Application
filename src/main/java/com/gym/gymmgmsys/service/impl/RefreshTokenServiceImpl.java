package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.entity.RefreshToken;
import com.gym.gymmgmsys.entity.User;
import com.gym.gymmgmsys.repository.RefreshTokenRepository;
import com.gym.gymmgmsys.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

import java.util.UUID;



@Service
@RequiredArgsConstructor
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {


    private final RefreshTokenRepository refreshTokenRepository;


    private final UserRepository userRepository;



    private final long refreshTokenDuration = 7;



    @Override
    public RefreshToken createRefreshToken(
            Long userId
    ){


        User user =
                userRepository.findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found"
                                )
                        );



        refreshTokenRepository.deleteByUser(user);



        RefreshToken refreshToken =
                new RefreshToken();


        refreshToken.setUser(user);


        refreshToken.setToken(
                UUID.randomUUID()
                        .toString()
        );


        refreshToken.setExpiryDate(
                LocalDateTime.now()
                        .plusDays(refreshTokenDuration)
        );



        return refreshTokenRepository.save(
                refreshToken
        );

    }




    @Override
    public RefreshToken verifyExpiration(
            RefreshToken token
    ){


        if(token.getExpiryDate()
                .isBefore(LocalDateTime.now())){


            refreshTokenRepository.delete(token);


            throw new RuntimeException(
                    "Refresh token expired"
            );

        }


        return token;

    }





    @Override
    public void deleteByUserId(
            Long userId
    ){

        User user =
                userRepository.findById(userId)
                        .orElseThrow();


        refreshTokenRepository.deleteByUser(user);

    }

}
