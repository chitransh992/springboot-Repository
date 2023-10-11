//package com.xebia.BloggingApplication.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(configurer->configurer
////                .requestMatchers("/swagger-ui/**").permitAll()
//                .requestMatchers(HttpMethod.POST,"/api/Role/").hasRole("ADMIN"));
//
//
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf->csrf.disable());
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/v3/api-docs/**");
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails ashish = User.builder()
//                .username("ashish")
//                .password("{noop}test123")
//                .roles("ADMIN","PRINCIPLE")
//                .build();
//
//
//        UserDetails raushan = User.builder()
//                .username("raushan")
//                .password("{noop}test123")
//                .roles("PRINCIPLE")
//                .build();
//
//        return new InMemoryUserDetailsManager(raushan,ashish);
//    }
//
//
//
//}
