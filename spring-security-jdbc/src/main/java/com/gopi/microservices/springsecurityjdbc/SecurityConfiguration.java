/**
 * Created by gopinath_mb on Jun 3, 2020
 */
package com.gopi.microservices.springsecurityjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.jdbcAuthentication().dataSource(dataSource)
    .usersByUsernameQuery("select username,password,enabled from my_user_table where username= ?")
    .authoritiesByUsernameQuery("select username, authority from my_authority_table where usernname= ?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests()
    .antMatchers("/admin").hasAnyRole("ADMIN")
    .antMatchers("/user").hasAnyRole("USER","ADMIN")
    .antMatchers("/").permitAll()
    .and().formLogin();
  
  }
  
  @Bean
  public PasswordEncoder getPasswordEncoder()
  {
    return NoOpPasswordEncoder.getInstance();
  }

}
