package com.bank.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurity {
	
	@Bean
	SecurityFilterChain MySecurityFilterChain(HttpSecurity http) throws Exception {
		
		
		http.authorizeHttpRequests( (auth)->auth
				.antMatchers("/account").authenticated()
				.antMatchers("/contact").permitAll()
		).httpBasic(Customizer.withDefaults());
		return http.build();

	}
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
		
		//With default password encoder
		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
		
		// with custom password encoder
		
		
		//InMemoryUserDetailsManager Object	
		 InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		 
		 //Upcasting as InMemoryUserDetailsManager extends UserDetails interface
		 	
		 	//User default class given by spring security
	        UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
	        UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
	        
	        //create user will put a keyvalue in hashmap of users
	        userDetailsService.createUser(admin);
	        userDetailsService.createUser(user);
	        return userDetailsService;
	}
	
	//Password encoder to avoid exception
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
}
