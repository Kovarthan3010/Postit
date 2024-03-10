package Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.projectposter.Service.userData;
@Configuration
@EnableWebSecurity
public class SecurityConfig{


@Bean
public UserDetailsService userDetailsService()
{
	return new userData();
}
	
@Bean
public PasswordEncoder passwordEncoder()
    {
	return new BCryptPasswordEncoder();
    }

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
     {
	 return http.csrf().disable()
	     .authorizeHttpRequests()
	     .requestMatchers("/login","/postings","/titles","/authors","/postingsByTitle","/postingsByAuthor","/register").permitAll()
	     .and()
	     .authorizeHttpRequests()
	     .requestMatchers("/**").authenticated()
	     .and().formLogin()
	     .defaultSuccessUrl("/myposts")
	     .and().logout()
	     .logoutUrl("/logout")
	     .logoutSuccessUrl("/login")
	     .deleteCookies("JSESSIONID")
	     .and().build();
	 }
@Bean
public AuthenticationProvider authenticationProvider()
{
	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	daoAuthenticationProvider.setUserDetailsService(userDetailsService());
	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	return daoAuthenticationProvider;
}
}
