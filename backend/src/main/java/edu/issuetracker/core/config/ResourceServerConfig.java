package edu.issuetracker.core.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .mvcMatchers("/api/*").hasAuthority("SCOPE_issue_tracker")
                .anyRequest().denyAll()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

}
