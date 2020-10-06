package com.ojas.crud.emp.security;

/*
 * @Configuration public class SpringSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
 * { auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.
 * crypto.password.NoOpPasswordEncoder.getInstance())
 * .withUser("user").password("pass").roles("USER") .and()
 * .withUser("admin").password("pass").roles("USER", "ADMIN"); }
 * 
 * 
 * protected void configure(HttpSecurity http) throws Exception {
 * http.httpBasic().and().authorizeRequests()
 * .antMatchers("/userlogin").hasRole("USER")
 * .antMatchers("/adminlogin").hasRole("ADMIN") .and()
 * .csrf().disable().headers().frameOptions().disable(); }
 * 
 * }
 */