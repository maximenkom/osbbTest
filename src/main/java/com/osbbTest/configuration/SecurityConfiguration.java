package com.osbbTest.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;		
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			
		 auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select email,password, enabled from users where email=?")
			.authoritiesByUsernameQuery(
				"select u.email, ur.role from user_roles ur join users u on ur.user_id=u.id and u.email=?")
			.passwordEncoder(passwordEncoder());			 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.authorizeRequests().antMatchers("/login").permitAll()
		 .antMatchers("/logout").authenticated()
         .antMatchers("/").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
         .antMatchers("/admin**/**").access("hasRole('ROLE_ADMIN')")
         .antMatchers("/manager**/**").access("hasRole('ROLE_MANAGER')")
         .antMatchers("/welcome**/**").access("hasRole('ROLE_USER')")
         .and()
         .formLogin().loginPage("/login").failureUrl("/login?error")
 	 	 .usernameParameter("username")
 		 .passwordParameter("password")
         .and()
         .logout().invalidateHttpSession(true).logoutSuccessUrl("/");                   		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


