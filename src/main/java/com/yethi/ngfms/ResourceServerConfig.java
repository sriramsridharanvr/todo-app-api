package com.yethi.ngfms;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	public TokenStore tokenStore;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		
		http.authorizeRequests()
				//.antMatchers("/api/profile/unsecured").permitAll()
//				.antMatchers("/api/tenants/**").hasAnyAuthority("INTERNAL", "Site Admin")
				.anyRequest().permitAll()
			.and()
				.cors().disable()
				.csrf().disable()
				.httpBasic().disable()
				.exceptionHandling()
					.authenticationEntryPoint(
						(request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
					.accessDeniedHandler(
						(request, response, authException) -> response.sendError(HttpServletResponse.SC_FORBIDDEN));
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("USER_ADMIN_RESOURCE").tokenStore(tokenStore);
	}

}
