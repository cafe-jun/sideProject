//package com.example.sideproject.backend.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.List;
//
//@Configurable
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable()) // API 서버면 보통 disable
//                .formLogin(form -> form.disable()) // 기본 로그인 폼 비활성화
//                .httpBasic(basic -> basic.disable()) // Basic Auth도 비활성화(선택)
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // 일단 모두 허용 (개발 단계)
//                )
////                .authorizeHttpRequests(auth -> auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
////                        .requestMatchers("/login","/signup","/error").permitAll()
////                        .requestMatchers("/swagger", "/swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**", "/v3/api-docs/**").permitAll()
////                        .requestMatchers("/admin/**").hasRole("ADMIN")
////                        .requestMatchers("/api/**").authenticated()
////                        .anyRequest().authenticated()
////                )
//                .build();
//
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration cfg = new CorsConfiguration();
//        cfg.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
//        cfg.setAllowedHeaders(List.of("Authorization","Content-Type","X-Request-Id"));
//        cfg.setExposedHeaders(List.of("Authorization"));
//        cfg.setAllowCredentials(true);
//        cfg.setMaxAge(3600L);
//
//        var source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", cfg);
//        return source;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
