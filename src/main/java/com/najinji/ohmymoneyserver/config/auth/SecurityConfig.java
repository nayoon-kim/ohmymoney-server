//package com.najinji.ohmymoneyserver.config.auth;
//
//import com.najinji.ohmymoneyserver.domain.user.Role;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////  스프링 시큐리티 설정
//    private final CustomOAuth2UserService customOAuth2UserService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .headers().frameOptions().disable()
//             .and()
//                .authorizeRequests()
//                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/place/**", "/fonts/**", "/svg/**").permitAll()
//                .antMatchers("/api/v1/**").permitAll()
//                .anyRequest().authenticated()
//             .and()
//                .logout()
//                .logoutSuccessUrl("/")
//             .and()
//                .oauth2Login()
//                .userInfoEndpoint()
//                .userService(customOAuth2UserService);
//    }
//}
