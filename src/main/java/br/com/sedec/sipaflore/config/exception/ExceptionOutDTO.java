package br.com.sedec.sipaflore.config.exception;

import br.com.sedec.sipaflore.util.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ExceptionOutDTO {

    private HttpStatus status;
    private String message;
    private LocalDateTime dateTime;

    public ExceptionOutDTO(final HttpStatus status, final String message, final LocalDateTime dateTime) {
        this.status = status;
        this.message = message;
        this.dateTime = dateTime;

        if (isNotBlank(message)) {
            this.message = Message.getMessage(message);
        }
    }

}
