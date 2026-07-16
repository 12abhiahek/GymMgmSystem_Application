package com.gym.gymmgmsys.controller;

import com.gym.gymmgmsys.dto.request.LoginRequest;
import com.gym.gymmgmsys.dto.request.RefreshTokenRequest;
import com.gym.gymmgmsys.dto.request.RegisterRequest;
import com.gym.gymmgmsys.dto.response.AuthResponse;
import com.gym.gymmgmsys.dto.response.TokenResponse;
import com.gym.gymmgmsys.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request
    ){

        return ResponseEntity.ok(
                authService.register(request)
        );

    }



    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request
    ){

        return ResponseEntity.ok(
                authService.login(request)
        );

    }

    @PostMapping("/refresh-token")
    public ResponseEntity<TokenResponse> refreshToken(
            @Valid @RequestBody RefreshTokenRequest request
    ){

        return ResponseEntity.ok(
                authService.refreshToken(request)
        );

    }



//    @PostMapping("/logout")
//    public ResponseEntity<String> logout(
//            Authentication authentication
//    ){
//
//        CustomUserDetails user =
//                (CustomUserDetails)
//                        authentication.getPrincipal();
//
//
//        authService.logout(
//                user.getUser().get
//        );
//
//        return ResponseEntity.ok(
//                "Logout successful"
//        );
//
//    }

//    @GetMapping("/me")
//    public ResponseEntity<User> currentUser(
//            Authentication authentication
//    ){
//
//        CustomUserDetails user =
//                (CustomUserDetails)
//                        authentication.getPrincipal();
//
//
//        return ResponseEntity.ok(
//                user.getUser()
//        );
//
//    }
}
