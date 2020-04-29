package com.example.demo.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/addcommande/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.POST, "/commande/**").permitAll();
        http.authorizeRequests().antMatchers( "/avis/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/article/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/reclamation/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/reclamation/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/article/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/addclient/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/modifyclient/**").permitAll();
       
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/reclamation/{id}/**").permitAll();
       

       
        http.authorizeRequests().anyRequest().authenticated();
       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
