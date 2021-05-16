package pl.sztukakodu.springsecuritytoken.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    @SneakyThrows
    protected void configure(HttpSecurity http) {
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(tokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @SneakyThrows
    private TokenAuthenticationFilter tokenFilter() {
        TokenAuthenticationFilter filter = new TokenAuthenticationFilter();
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }
}
