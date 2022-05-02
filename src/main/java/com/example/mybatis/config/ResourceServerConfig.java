package com.example.mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author sun
 */
@Configuration
@EnableResourceServer
//@EnableAuthorizationServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilter(), ChannelProcessingFilter.class).csrf().disable().authorizeRequests()
//		.antMatchers("/static/**", "/first/**", "/user/**").permitAll()
				.antMatchers("/static/images/**","/index").permitAll()
				.antMatchers("/**").authenticated();

	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Bean
	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.PUT);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
