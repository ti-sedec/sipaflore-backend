package br.com.sedec.sipaflore.config.security.config;

import br.com.sedec.sipaflore.config.exception.ExceptionOutDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static java.lang.Boolean.FALSE;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException {
        log.error(authException.getMessage(), authException);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(WRITE_DATES_AS_TIMESTAMPS, FALSE);
        response.setStatus(SC_UNAUTHORIZED);
        response.setHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getOutputStream(), new ExceptionOutDTO(UNAUTHORIZED, authException.getMessage(), now()));
    }

}
