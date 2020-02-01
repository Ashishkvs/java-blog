package com.imagegrafia.blog.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.Data;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/api").hasAnyRole("ADMIN");
//		http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
//		http.csrf().disable().antMatcher("/h2-console/");
		http.httpBasic().and().authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN");
		
		
	}
	
	@Bean
	@ConfigurationProperties("app.security")
	SecurityProperties securityProperties() {
		return new SecurityProperties();
	}

	/*private static final String ROLE_ADMIN_CONST = "ADMIN";
	private static final String ROLE_USER_CONST = "USER";*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		for(Map.Entry<String, User> entry : securityProperties().users.entrySet()) {
			User user = entry.getValue();
			auth.inMemoryAuthentication().withUser(user.name).password("{noop}" + user.password).roles(user.roles);
		}
	}


		@Data
		static class User {
			String name;
			String password;
			String[] roles;
		}
		
		@Data
		static class SecurityProperties{
			Map<String,User> users;
		}

}
