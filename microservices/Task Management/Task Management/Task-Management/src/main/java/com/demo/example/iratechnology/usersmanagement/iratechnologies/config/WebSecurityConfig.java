/* package com.demo.example.iratechnology.usersmanagement.iratechnologies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // TODO Auto-generated method stub
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("ms-taskmanagement/api/task/creation").hasRole("Manager")
        .antMatchers("ms-taskmanagement/api/task/checkstatus/*").hasRole("Manager")
        .antMatchers("ms-taskmanagement/api/task/updation").hasRole("Manager")
        .antMatchers("ms-taskmanagement/api/task/workerupdation/{id}").hasRole("Worker");

    }

 
    





}
 */