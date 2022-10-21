/**
 * 
 */
/*
 * package com.hacorp.authen.configuration;
 * 
 * import com.hacorp.shop.security.JwtAuthenticationEntryPoint; import
 * com.hacorp.shop.security.JwtRequestFilter; import
 * com.hacorp.shop.service.impl.UserDetailsServiceImpl; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.web.servlet.FilterRegistrationBean; import
 * org.springframework.boot.web.servlet.ServletListenerRegistrationBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.session.SessionRegistry; import
 * org.springframework.security.core.session.SessionRegistryImpl; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.security.web.session.HttpSessionEventPublisher; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource; import
 * org.springframework.web.filter.CorsFilter;
 * 
 * import java.util.Arrays;
 * 
 * 
 * 
 *//**
	 * @author Kraken
	 *
	 *//*
		 * @Configuration
		 * 
		 * @EnableWebSecurity public class WebSecurityConfig extends
		 * WebSecurityConfigurerAdapter {
		 * 
		 * @Autowired private UserDetailsServiceImpl userDetailsService;
		 * 
		 * 
		 * @Autowired private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
		 * 
		 * @Autowired private JwtRequestFilter jwtRequestFilter;
		 * 
		 * @Bean public BCryptPasswordEncoder passwordEncoder() { BCryptPasswordEncoder
		 * bCryptPasswordEncoder = new BCryptPasswordEncoder(); return
		 * bCryptPasswordEncoder; }
		 * 
		 * // @Bean // public AuthenticationManager authenticationManagerBean() throws
		 * Exception { // return super.authenticationManagerBean(); // }
		 * 
		 * @Bean
		 * 
		 * @Override protected AuthenticationManager authenticationManager() throws
		 * Exception { // TODO Auto-generated method stub return
		 * super.authenticationManager(); }
		 * 
		 * @Bean public SessionRegistry sessionRegistry() { SessionRegistry
		 * sessionRegistry = new SessionRegistryImpl(); return sessionRegistry; }
		 * 
		 * // Register HttpSessionEventPublisher
		 * 
		 * @Bean public static ServletListenerRegistrationBean
		 * httpSessionEventPublisher() { return new ServletListenerRegistrationBean(new
		 * HttpSessionEventPublisher()); }
		 * 
		 * @Bean public FilterRegistrationBean corsFilter() {
		 * UrlBasedCorsConfigurationSource source = new
		 * UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
		 * CorsConfiguration(); config.setAllowCredentials(true);
		 * config.setAllowedOriginPatterns(Arrays.asList("*"));
		 * config.addAllowedHeader("*"); config.addAllowedMethod("*");
		 * source.registerCorsConfiguration("/**", config); FilterRegistrationBean bean
		 * = new FilterRegistrationBean(new CorsFilter(source)); bean.setOrder(0);
		 * return bean; }
		 * 
		 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
		 * throws Exception {
		 * 
		 * // Setting Service to find User in the database. // And Setting
		 * PassswordEncoder
		 * auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()
		 * ); auth.jdbcAuthentication() .usersByUsernameQuery("")
		 * .authoritiesByUsernameQuery("") .dataSource(dataSource);
		 * 
		 * }
		 * 
		 * @Override protected void configure(HttpSecurity http) throws Exception {
		 * http.csrf().disable();
		 * 
		 * // The pages does not require login http.authorizeRequests() //
		 * .antMatchers("/api/user/**") // .authenticated() //
		 * .antMatchers("/api/admin/**").authenticated() // .anyRequest().permitAll();
		 * .antMatchers("/api/authentication","/api/signup") .permitAll()
		 * .antMatchers(HttpMethod.GET,"/api/products") .permitAll()
		 * .antMatchers(HttpMethod.GET,"/api/meta") .permitAll()
		 * .antMatchers(HttpMethod.OPTIONS) .permitAll() .anyRequest().authenticated();
		 * 
		 * // AccessDeniedException will be thrown.
		 * http.authorizeRequests().and().exceptionHandling().authenticationEntryPoint(
		 * jwtAuthenticationEntryPoint)
		 * .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
		 * STATELESS);
		 * 
		 * // Add a filter to validate the tokens with every request
		 * http.addFilterBefore(jwtRequestFilter,
		 * UsernamePasswordAuthenticationFilter.class);
		 * 
		 * } }
		 */