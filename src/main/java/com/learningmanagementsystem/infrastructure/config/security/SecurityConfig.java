package com.learningmanagementsystem.infrastructure.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // to override the default spring security config
public class SecurityConfig {


    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() { // InMemoryUserDetailsManager implements UserDetailsManager which extends UserDetailsService Interface
//        UserDetails user1 = User.builder().username("ziad").password("{noop}osama").roles("ADMIN").build();
//        UserDetails user2 = User.builder().username("ziad2").password("{noop}osama2").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
    @Autowired
    private JwtFilter jwtFilter;

    @Bean // Spring will look for this..if not it will use the default of spring security
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/api/v1/register/**","/api/v1/login/**",
                                        "/api/v1/refresh_token/**").permitAll()
                                .requestMatchers("/api/v1/users/**").hasAuthority("admin")
                                .anyRequest().authenticated())
                                .formLogin(Customizer.withDefaults()) // for web
                                .httpBasic(Customizer.withDefaults())// for postman
                                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Never use session ID..Spring will generate different Session ID Everytime...for JWT and REST APIs
                                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
//    @Bean                                           // more generic than injecting the first bean which is "public InMemoryUserDetailsManager userDetailsManager()"
//    public UserDetailsService userDetailsService() { // InMemoryUserDetailsManager implements UserDetailsManager which extends UserDetailsService Interface
//        UserDetails user1 = User.builder().username("ziad").password("{noop}osama").roles("ADMIN").build();
//        UserDetails user2 = User.builder().username("ziad2").password("{noop}osama2").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        authProvider.setUserDetailsService(userDetailsService);
//        return authProvider;
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
