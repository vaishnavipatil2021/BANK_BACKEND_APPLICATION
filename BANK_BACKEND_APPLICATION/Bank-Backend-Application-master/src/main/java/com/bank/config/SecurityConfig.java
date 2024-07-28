package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indication to spring boot that we have certain config.
public class SecurityConfig {
//Spring boot 3
	@Bean
	SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.requestMatchers("/myBalance", "/myAccount", "/myLoan", "/myCards").authenticated()
		.requestMatchers("/myNotice", "/contact").permitAll().and().formLogin().and().httpBasic();
		return http.build();

// SPring boot 6 and forward
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				authorize -> authorize.requestMatchers("/blog/**").permitAll().anyRequest().authenticated())
//				.formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
//				.rememberMe(Customizer.withDefaults());
//
//		return http.build();

	}

}
