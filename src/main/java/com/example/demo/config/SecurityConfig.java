@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .exceptionHandling(e -> e.authenticationEntryPoint(entryPoint))
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/",                // root URL
                "/index.html",      // default page
                "/error",           // spring error page
                "/auth/**"          // login/register
            ).permitAll()
            .anyRequest().authenticated()
        );

    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
}
