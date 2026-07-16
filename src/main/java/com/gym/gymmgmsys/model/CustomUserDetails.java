package com.gym.gymmgmsys.model;

import com.gym.gymmgmsys.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(
                new SimpleGrantedAuthority(
                        user.getRole().getName().name()
                )
        );

    }

    @Override
    public String getPassword() {

        return user.getPassword();

    }

    @Override
    public String getUsername() {

        return user.getEmail();

    }

    @Override
    public boolean isAccountNonLocked() {

        return !user.isAccountLocked();

    }

    @Override
    public boolean isEnabled() {

        return user.isEnabled();

    }
}
