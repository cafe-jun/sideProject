package com.example.sideproject.backend.dto.security;


import com.example.sideproject.backend.domain.user.UserRoleType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record BoardPrincipal(
        String username,
        String password,
        Collection<? extends GrantedAuthority> authorities,
        String email,
        String nickname,
        String memo,
)  implements UserDetails {

    public static BoardPrincipal of(String username,String password,String email,String nickname,String memo){
        Set<UserRoleType> userRoleTypeSet = Set.of(UserRoleType.USER);
        return new BoardPrincipal(
                username,
                password,
                userRoleTypeSet.stream()
                        .map(UserRoleType::getDeclaringClass)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet()),
                email,
                nickname,
                memo
        );

    }

    public static BoardPrincipal from() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}