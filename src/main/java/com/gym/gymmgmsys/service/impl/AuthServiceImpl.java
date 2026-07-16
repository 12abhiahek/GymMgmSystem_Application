package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.common.config.jwt.JwtService;
import com.gym.gymmgmsys.dto.request.LoginRequest;
import com.gym.gymmgmsys.dto.request.RefreshTokenRequest;
import com.gym.gymmgmsys.dto.request.RegisterRequest;
import com.gym.gymmgmsys.dto.response.AuthResponse;
import com.gym.gymmgmsys.dto.response.TokenResponse;
import com.gym.gymmgmsys.entity.Role;
import com.gym.gymmgmsys.entity.RoleName;
import com.gym.gymmgmsys.entity.User;
import com.gym.gymmgmsys.model.CustomUserDetails;
import com.gym.gymmgmsys.repository.RoleRepository;
import com.gym.gymmgmsys.repository.UserRepository;
import com.gym.gymmgmsys.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {



    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;




    /**
     * Register New User
     */
    @Override
    public AuthResponse register(
            RegisterRequest request
    ) {


        if(userRepository.existsByEmail(request.getEmail())){

            throw new RuntimeException(
                    "Email already registered"
            );

        }



        Role memberRole =
                roleRepository.findByName(
                                RoleName.ROLE_MEMBER
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Default role not found"
                                )
                        );



        User user = new User();


        user.setFirstName(
                request.getFirstName()
        );


        user.setLastName(
                request.getLastName()
        );


        user.setEmail(
                request.getEmail()
        );


        user.setPhone(
                request.getPhone()
        );


        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );


        user.setRole(
                memberRole
        );


        user.setEnabled(true);


        user.setAccountLocked(false);



        User savedUser =
                userRepository.save(user);



        CustomUserDetails userDetails =
                new CustomUserDetails(
                        savedUser
                );



        String accessToken =
                jwtService.generateToken(
                        userDetails
                );


        String refreshToken =
                jwtService.generateRefreshToken(
                        userDetails
                );



        return buildResponse(
                savedUser,
                accessToken,
                refreshToken
        );

    }







    /**
     * Login User
     */
    @Override
    public AuthResponse login(
            LoginRequest request
    ) {



        Authentication authentication =
                authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(

                                request.getEmail(),

                                request.getPassword()

                        )

                );



        CustomUserDetails userDetails =
                (CustomUserDetails)
                        authentication.getPrincipal();



        User user =
                userRepository.findByEmail(
                                userDetails.getUsername()
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found"
                                )
                        );



        String accessToken =
                jwtService.generateToken(
                        userDetails
                );


        String refreshToken =
                jwtService.generateRefreshToken(
                        userDetails
                );



        return buildResponse(
                user,
                accessToken,
                refreshToken
        );

    }

    @Override
    public TokenResponse refreshToken(RefreshTokenRequest request) {
        return null;
    }

    @Override
    public void logout(Long userId) {

    }


    /**
     * Build Response
     */
    private AuthResponse buildResponse(
            User user,
            String accessToken,
            String refreshToken
    ){


        return AuthResponse.builder()

                .userId(
                        user.getRole().getId()
                )

                .email(
                        user.getEmail()
                )

                .role(
                        user.getRole()
                                .getName()
                                .name()
                )

                .accessToken(
                        accessToken
                )

                .refreshToken(
                        refreshToken
                )

                .tokenType(
                        "Bearer"
                )

                .build();

    }


}
