/**
 * Created by gopinath_mb on Jun 2, 2020
 */
package com.gopi.microservices.springbootsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gopinath_mb
 */
@RestController
public class WelcomeResource
{
  @GetMapping("/")
  public String welcome()
  {
    return "<h1>Welcome To All<h1>";
  }
  
  @GetMapping("/user")
  public String user()
  {
    return "<h1>Welcome User<h1>";
  }
  
  @GetMapping("/abc")
  public String abc()
  {
    return "<h1>Welcome abc<h1>";
  }
  
  @GetMapping("/admin")
  public String admin()
  {
    return "<h1>Welcome Admin<h1>";
  }

}
