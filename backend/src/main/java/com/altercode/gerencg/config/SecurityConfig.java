package com.altercode.gerencg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf
						.ignoringRequestMatchers(toH2Console())
						.disable()
				)
				.csrf(AbstractHttpConfigurer::disable)
				.cors((cors -> cors.configure(http)))
				.authorizeHttpRequests(authorizeRequests ->
						authorizeRequests.requestMatchers("/**").permitAll()
								.requestMatchers(toH2Console()).permitAll()
								.anyRequest().authenticated()
				)
				.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
		return http.build();
	}
}