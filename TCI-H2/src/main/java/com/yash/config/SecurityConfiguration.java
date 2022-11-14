package com.yash.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	        .cors().disable()
	        .csrf().disable()
	        .httpBasic()
	        .and()
	        .authorizeHttpRequests()
	        .antMatchers("/postEmployee")
	        .hasRole("Admin")
	        .antMatchers("/getEmployee")
	        .hasAnyRole("Admin","User")
	        .and()
	        .formLogin();
	        return http.build();
	    }
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService(List<UserDetails> users) {
		
		UserDetails user1=User.withDefaultPasswordEncoder()
				.username("someshwar")
				.password("somesh@1234")
				.roles("Admin")
				.build();
		
		UserDetails user2=User.withDefaultPasswordEncoder()
				.username("anurag")
				.password("anurag@1234")
				.roles("User")
				.build();
		
		users.add(user1);
		users.add(user2);
		
		return new InMemoryUserDetailsManager(users);
	}
}
