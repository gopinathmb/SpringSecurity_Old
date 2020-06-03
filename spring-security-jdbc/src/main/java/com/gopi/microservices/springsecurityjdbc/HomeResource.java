/**
 * Created by gopinath_mb on Jun 2, 2020
 */
package com.gopi.microservices.springsecurityjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gopinath_mb
 */
@RestController
public class HomeResource
{

  @GetMapping("/")
  public String home()
  {
    return "<h1>Welcome To All<h1>";
  }

  @GetMapping("/user")
  public String user()
  {
    return "<h1>Welcome User<h1>";
  }

  @GetMapping("/admin")
  public String admin()
  {
    return "<h1>Welcome Admin<h1>";
  }

}
