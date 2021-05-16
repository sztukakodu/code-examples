package pl.sztukakodu.springsecuritytoken.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import pl.sztukakodu.springsecuritytoken.users.TokenRepository;
import pl.sztukakodu.springsecuritytoken.users.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
class TokenAuthenticationFilter extends GenericFilterBean {

    private final TokenRepository tokenRepository;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authorization = httpRequest.getHeader("Authorization");
        if (authorization != null) {
            fetchUser(StringUtils.removeStartIgnoreCase(authorization, "Bearer").trim())
                .map(details -> new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities()))
                .ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));
        }
        chain.doFilter(request, response);
    }

    private Optional<TasketteUserDetails> fetchUser(String digest) {
        return userService.findByToken(digest, clock.time())
                          .map(TasketteUserDetails::new);
    }
}
