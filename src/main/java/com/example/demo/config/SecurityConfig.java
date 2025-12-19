// package com.example.demo.config;

// import com.example.demo.security.JwtAuthenticationEntryPoint;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

//     public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
//         this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http
//             .csrf(csrf -> csrf.disable())
//             .exceptionHandling(ex ->
//                     ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//             .sessionManagement(session ->
//                     session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//             .authorizeHttpRequests(auth -> auth
//                     .requestMatchers(
//                             "/swagger-ui/**",
//                             "/v3/api-docs/**"
//                     ).permitAll()
//                     .anyRequest().authenticated()
//             );

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration authenticationConfiguration)
//             throws Exception {

//         return authenticationConfiguration.getAuthenticationManager();
//     }
// }
