package user.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsersUserDetailService usersUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/member/**").authenticated()
								.antMatchers("/manager/**").hasRole("MANAGER")
								.antMatchers("/admin/**").hasRole("ADMIN");
		http.csrf().disable();
		http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		http.userDetailsService(usersUserDetailService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	//인증에 필요한 사용자 정보를 메모리에 저장
	//{noop} :  비밀번호를 암호화 처리하지 않는다.
	
	/*
	 * @Autowired public void authenticate(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication() .withUser("manager")
	 * .password("{noop}manager123") .roles("MANAGER");
	 * 
	 * auth.inMemoryAuthentication() .withUser("admin") .password("{noop}admin123")
	 * .roles("ADMIN"); }
	 */
	 
}
