package com.blazdemsar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void 	configure(AuthenticationManagerBuilder auth) throws Exception{

		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
		
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		return bCryptPasswordEncoder;
		
	}
	
	@Override
	protected void 	configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/", "/home", "/user", "/saveUser").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/account").permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
		.and()
		.logout().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();  // cross-site-resource-forgery should be disabled, because server and client are on the same machine.
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/img/*", "/css/*");
	}
}
