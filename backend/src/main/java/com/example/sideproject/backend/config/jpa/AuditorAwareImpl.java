//package com.example.sideproject.backend.config.jpa;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.Optional;
//
//@Slf4j
//public class AuditorAwareImpl implements AuditorAware<Long> {
//
//
//    @Override
//    public Optional<Long> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if(authentication.getPrincipal().equals("anonymousUser")){
//            return Optional.of(99999999L);
//        }
//
//        Long userId = Long.parseLong(authentication.getPrincipal().toString());
//
//        return Optional.of(userId);
//    }
//}
