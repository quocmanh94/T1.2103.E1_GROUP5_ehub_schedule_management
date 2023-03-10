/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.config;

import com.example.DemoProjectSem04.custom.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());

        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] staticResources = {
            "/admin/assets/css/**",
            "/admin/assets/js/**",
            "/admin/assets/plugins/**",
            "/admin/assets/img/**","/admin/assets/fonts/**",};

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/aka/**").permitAll()
                .antMatchers("/client/**").permitAll()
                .antMatchers(staticResources).permitAll()
//                .antMatchers("/admin/dashboard").hasAnyAuthority("FUNCT00014")
                .antMatchers("/admin/module").hasAnyAuthority("FUNCT00001")
                .antMatchers("/admin/stafflist").hasAnyAuthority("FUNCT00002")
                .antMatchers("/admin/users").hasAnyAuthority("FUNCT00003")
                .antMatchers("/admin/student").hasAnyAuthority("FUNCT00007")
                .antMatchers("/admin/classes").hasAnyAuthority("FUNCT00004")
                .antMatchers("/admin/workingschedule").hasAnyAuthority("FUNCT00005")
//                .antMatchers("/admin/index").hasAnyAuthority("FUNCT00023")
                //                .antMatchers("/pages/staffdashboard").hasAnyAuthority("FUNCT00009")
//                .antMatchers("/admin/index").hasAnyAuthority("FUNCT00013")
                .antMatchers("/admin/setting").hasAnyAuthority("FUNCT00016")
                .antMatchers("/admin/staffdashboard").hasAnyAuthority("FUNCT00006")
//                .antMatchers("/admin/teacherdashboard").hasAnyAuthority("FUNCT00018")
                //                .antMatchers("/pages/teacherdashboard").hasAnyAuthority("FUNCT00027")
//                .antMatchers("/admin/studenttimetable").hasAnyAuthority("FUNCT00028")
                .antMatchers("/admin/teachingDate").hasAnyAuthority("FUNCT00010")
                .antMatchers("/admin/fee").hasAnyAuthority("FUNCT00008")
//                .antMatchers("/admin/fee").hasAnyAuthority("FUNCT00030")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/j_spring_security_check").loginPage("/admin/login").defaultSuccessUrl("/admin/rolepermission")
                .failureUrl("/admin/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/admin/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
