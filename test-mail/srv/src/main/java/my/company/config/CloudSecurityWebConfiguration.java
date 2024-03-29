package my.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class CloudSecurityWebConfiguration extends WebSecurityConfigurerAdapter {
	 @Override 
	  public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/odata/v2/**");
	  }
}
