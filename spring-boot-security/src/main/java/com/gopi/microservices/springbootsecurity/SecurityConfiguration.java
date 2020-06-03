/**
 * Created by gopinath_mb on Jun 2, 2020
 */
package com.gopi.microservices.springbootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author gopinath_mb
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

  //Authentication
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    //list of users and their passwords.
    auth.inMemoryAuthentication().withUser("blah").password("blah")
        .roles("USER").and().withUser("foo").password("foopassword")
        .roles("USER").and().withUser("gopi").password("gopi").roles("ADMIN");
  }

  //Authorization
  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests()
    .antMatchers("/admin").hasAnyRole("ADMIN")
    .antMatchers("/user").hasAnyRole("USER")
    .antMatchers("/").permitAll()
    .and().formLogin();
  }
  
  @Bean
  public PasswordEncoder getPasswordEncoder()
  {
    // Password encryption used above in the list is username and
    // password.NoOpPasswordEncoder means it is plain text, but in production u must use proper password.
    return NoOpPasswordEncoder.getInstance();
  }
}
