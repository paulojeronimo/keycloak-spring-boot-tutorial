package com.example.demo;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class KeycloakSecurityConfigurer extends KeycloakWebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) {
    final SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
    mapper.setConvertToUpperCase(true);

    final KeycloakAuthenticationProvider provider = keycloakAuthenticationProvider();
    provider.setGrantedAuthoritiesMapper(mapper);

    auth.authenticationProvider(provider);
  }

  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new NullAuthenticatedSessionStrategy();
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    super.configure(http);
    http.authorizeRequests();
  }

  @Bean
  KeycloakConfigResolver keycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }
}
