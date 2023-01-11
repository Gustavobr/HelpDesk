package br.com.qintess.config;

import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	public static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };

	@Value("${spring.security.username}")
	private static String username;

	@Value("${spring.security.password}")
	private static String password;

	@Autowired

	private org.springframework.core.env.Environment env;

	@Bean

	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return (CorsConfigurationSource) source;
	}

	@Bean

	protected void configure(AuthenticationManagerBuilder auth) throws AuthenticationException, Exception {
		try {

			auth.inMemoryAuthentication().withUser(SecurityConfig.username).password(SecurityConfig.password)
					.credentialsExpired(false);
		} catch (AuthenticationException ex) {
			ex.printStackTrace();
		}
	}
	


}
