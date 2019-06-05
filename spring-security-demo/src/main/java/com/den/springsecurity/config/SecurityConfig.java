package com.den.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String EMPLOYEE = "EMPLOYEE";
	private static final String MANAGER = "MANAGER";
	private static final String ADMIN = "ADMIN";
	private static final String ENCODED_PASSWORD = "$2a$10$qY66kvHjO18UvaC6I59pSOsaVV3Zcq3TEcIIkur2CgMVwzYPdALCe"; // "test123"

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("encode password \"test123\": " + passwordEncoder().encode("test123"));
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//				.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//				.withUser(users.username("mary").password("test123").roles("MANAGER"))
//				.withUser(users.username("susan").password("test123").roles("ADMIN"));

		auth.inMemoryAuthentication() // safe version, without deprecated method
				.passwordEncoder(passwordEncoder())
				.withUser("john").password(ENCODED_PASSWORD).roles(EMPLOYEE).and()
				.withUser("mary").password(ENCODED_PASSWORD).roles(EMPLOYEE, MANAGER).and()
				.withUser("susan").password(ENCODED_PASSWORD).roles(EMPLOYEE, ADMIN);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").hasRole(EMPLOYEE)
				.antMatchers("/leaders/**").hasRole(MANAGER)
				.antMatchers("/systems/**").hasRole(ADMIN)
//				.anyRequest().authenticated()
				.and().formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and().logout()
//					.logoutUrl("/logout")
					.permitAll()
				.and().exceptionHandling()
					.accessDeniedPage("/access-denied");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
