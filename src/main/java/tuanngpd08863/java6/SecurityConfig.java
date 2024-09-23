package tuanngpd08863.java6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tuanngpd08863.java6.entity.Account;
import tuanngpd08863.java6.service.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AccountService accountService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Account user = accountService.findById(username);
            if (user == null) {
                throw new UsernameNotFoundException(username + " not found!");
            }
            String password = "{noop}" + user.getPassword(); 
            String[] roles = user.getAuthorities().stream()
                    .map(er -> er.getRole().getId())
                    .toArray(String[]::new);
            return User.withUsername(username)
                    .password(password)
                    .roles(roles)
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder delegatingPasswordEncoder = 
                (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
        return delegatingPasswordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/order/**").authenticated()
                    .requestMatchers("/admin/**").hasAnyRole("STAF", "DIRE", "ADMIN", "CUST")
                    .requestMatchers("/rest/authorities").hasAnyRole("DIRE", "ADMIN", "STAF", "CUST")
                    .requestMatchers("/**").permitAll()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/security/login/form")
                    .loginProcessingUrl("/security/login")
                    .defaultSuccessUrl("/security/login/success", false)
                    .failureUrl("/security/login/error")
            )
            .rememberMe(rememberMe ->
                rememberMe
                    .tokenValiditySeconds(86400)
            )
            .logout(logout ->
                logout
                    .logoutUrl("/security/logoff")
                    .logoutSuccessUrl("/security/logoff/success")
            );

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(HttpMethod.OPTIONS, "/**");
    }
}
