package com.proptiger.mortgage.web.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedOriginPatterns(List.of("https://*.housing.com", "https://housing.com"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable()
                .cors().configurationSource(request -> corsConfiguration);
    }

    @Bean
    public HttpFirewall configureFirewall() {
        StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
        strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
        return strictHttpFirewall;
    }
}
