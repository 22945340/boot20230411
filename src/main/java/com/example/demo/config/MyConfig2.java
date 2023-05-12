package com.example.demo.config;

import java.util.*;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;
import org.springframework.security.web.access.expression.*;

@Configuration
@EnableMethodSecurity
public class MyConfig2 {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) 
			throws Exception {
		http.formLogin()
			.loginPage("/sub33/mylogin")
			.defaultSuccessUrl("/sub33/loginSuccess", true)
			.usernameParameter("id") // 기본값 : username
			.passwordParameter("pw"); // 기본값 : password
		
		http.csrf().disable();
		
		http.authorizeHttpRequests().requestMatchers("/abc").authenticated();
		
		
		http.authorizeHttpRequests().anyRequest().permitAll();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = passwordEncoder();
		
		String pw1 = encoder.encode("pw1");
		String pw2 = encoder.encode("pw2");
		
		System.out.println("pw1 : " + pw1);
		System.out.println("pw2 : " + pw2);
		
		UserDetails user1 = User.builder().username("user1")
				.password(pw1)
				.authorities(List.of(
						new SimpleGrantedAuthority("admin"),
						new SimpleGrantedAuthority("manager")
						))
				.build();
		
		UserDetails user2 = User.builder().username("user2")
				.password(pw2)
				.authorities(List.of(
						new SimpleGrantedAuthority("manager"),
						new SimpleGrantedAuthority("user")
						))
				.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}





