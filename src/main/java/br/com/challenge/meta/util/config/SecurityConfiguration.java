package br.com.challenge.meta.util.config;

import br.com.challenge.meta.filters.JwtAuthenticationEntryPointFilter;
import br.com.challenge.meta.filters.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Class that implements the Travels Java API Spring Security configurations.
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final JwtAuthenticationEntryPointFilter unauthorizedHandler;
  private final UserDetailsService userDetailsService;

  @Value("${spring.profiles.active}")
  private String activeProfile;

  /**
   * Method to configure the type of authentication in the API
   *
   * @param authenticationManagerBuilder
   * @throws Exception
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @Autowired
  public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
  }

  /**
   * @author Felipe Santiago
   * @see WebSecurityConfigurerAdapter#authenticationManagerBean()
   * @since 2021-03-12
   */
  @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  /**
   * Method to create an BCrypt password encoder
   *
   * @return PasswordEncoder object
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Method to create an Authentication Token Filter Bean
   *
   * @return JwtAuthenticationTokenFilter object
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @Bean
  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() {
    return new JwtAuthenticationTokenFilter();
  }

  /**
   * @author Felipe Santiago
   * @see WebSecurityConfigurerAdapter#configure(WebSecurity)
   * @since 2021-03-12
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    if (activeProfile.equals("test")) {
      http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    } else {
      http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
          .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
          .antMatchers("/v1/auth/**", "/configuration/security", "/webjars/**",
              "/v2/api-docs", "/swagger-resources/**", "/swagger-ui/**", "/manage/**")
          .permitAll().anyRequest().authenticated();
      http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
      http.headers().cacheControl();
    }
  }
}