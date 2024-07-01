package br.com.sedec.sipaflore.config.security.config;

import br.com.sedec.sipaflore.config.exception.ExceptionOutDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static java.lang.Boolean.FALSE;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response,
                       final AccessDeniedException exception) throws IOException {

        final HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        final ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(WRITE_DATES_AS_TIMESTAMPS, FALSE);
        response.setStatus(httpStatus.value());
        response.addHeader("content-type", "application/json;uft-8");
        mapper.writeValue(response.getOutputStream(), new ExceptionOutDTO(UNAUTHORIZED, "error.access-denied", now()));
    }

}
