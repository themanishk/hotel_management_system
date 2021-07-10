package com.demo2.demo2.security;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;





@Configuration
@EnableWebSecurity
public class appsecurityconfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	

	
	@Bean
	public AuthenticationProvider authProvider() {
		

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()				// URLs matching for access rights
				.antMatchers("/", "/css/**" , "/js/**").permitAll()
				.antMatchers("/register","/registersuccess ","/updateroominfosuccess", "/updateroominfo").permitAll()
				.antMatchers("/booking/**" , "/guestinfo", "/payment" ) .hasAnyAuthority("owner","manager", "assistant")
				
				.anyRequest().authenticated()
				.and()
				// form login
				.formLogin().loginPage("/signin").permitAll().and().csrf().disable()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.and()
				.exceptionHandling().accessDeniedPage("/")
				;
				//.formLogin()
				//.loginPage("/login")
				//.failureUrl("/login?error=true")
				//.usernameParameter("username")
				//.passwordParameter("password")
				/*.and()
				// logout
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");*/
	}
	

//	@Override
	//@Bean
	//protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub


		//List<UserDetails> users = new ArrayList<>();
		//users.add(User.withDefaultPasswordEncoder().username("manish").password("1234").roles("USER").build());
		
		//return new InMemoryUserDetailsManager(users);
	//}   
	
	

}
