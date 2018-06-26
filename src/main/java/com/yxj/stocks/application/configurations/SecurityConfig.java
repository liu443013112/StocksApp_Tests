package com.yxj.stocks.application.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("a").password("test").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // allow all user to use stockInfo
        http.authorizeRequests()

                .anyRequest()
                .permitAll()
                .and()
                .httpBasic();


/*
                .antMatchers("/stockInfo/**", "/swagger-ui.html").permitAll()
                // authentication is required for all other pages
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // specify the login page URI
                .loginPage("/stockInfo/FB")
                .permitAll()
                .and().httpBasic();*/
        http.csrf().disable();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


}
