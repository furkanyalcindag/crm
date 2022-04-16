package com.comitfy.healtie.configuration;

import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.security.JWTFilter;
import com.comitfy.healtie.util.security.SecurityService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private JWTFilter filter;
	@Autowired
	private SecurityService uds;

	/*

	http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();

	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.csrf().disable()
				.httpBasic().disable()
				.cors()
				.and()
				.authorizeHttpRequests()
				.antMatchers("/swagger-ui/**").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/api/auth/**").permitAll()
				.antMatchers("/api/user/**").hasRole("USER")
				.antMatchers("/deneme/**").hasRole("USER")
				.and()
				.userDetailsService(uds)
				.exceptionHandling()
				.authenticationEntryPoint(
						(request, response, authException) ->
								response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
				)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}