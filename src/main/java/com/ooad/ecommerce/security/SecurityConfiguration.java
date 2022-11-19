package com.ooad.ecommerce.security;

import com.ooad.ecommerce.views.login.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

  public static final String LOGOUT_URL = "/";

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PlainTextPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .requestMatchers(new AntPathRequestMatcher("/images/*.png"))
        .permitAll();
    super.configure(http);
    setLoginView(http, LoginView.class, LOGOUT_URL);
  }
}
