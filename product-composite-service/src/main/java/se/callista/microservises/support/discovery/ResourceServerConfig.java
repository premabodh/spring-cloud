package se.callista.microservises.support.discovery;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 
 * @author Filip Lindby
 *
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "oauth2-resource";

	

	@Override
	public void configure(HttpSecurity http) throws Exception {				
		http
			.requestMatchers().antMatchers("/**")
		.and()
    		.authorizeRequests()		
    		.antMatchers("/product/**").access("hasRole('CLIENT')")	
    		.antMatchers("/demo/**").permitAll()
    		.anyRequest().authenticated();		
	}

//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {			
//		resources
//			.resourceId(RESOURCE_ID)
//			;
//	}

	

}
