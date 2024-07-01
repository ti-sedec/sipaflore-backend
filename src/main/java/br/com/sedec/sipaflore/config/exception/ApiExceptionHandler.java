package br.com.sedec.sipaflore.config.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.atomic.AtomicReference;

import static br.com.sedec.sipaflore.util.Message.getMessage;
import static java.time.LocalDateTime.now;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${application.stacktrace-enabled}")
    private Boolean enableStacktrace;

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionOutDTO> unauthorizedException(final UnauthorizedException exception) {
        logException(exception);

        return ResponseEntity.status(UNAUTHORIZED).body(
            ExceptionOutDTO.builder()
                .status(UNAUTHORIZED)
                .message(exception.getMessage())
                .dateTime(now())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionOutDTO> badRequestException(final BadRequestException exception) {
        logException(exception);

        return ResponseEntity.status(BAD_REQUEST).body(
            ExceptionOutDTO.builder()
                .status(BAD_REQUEST)
                .message(exception.getMessage())
                .dateTime(now())
                .build());
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final @NotNull HttpHeaders headers,
                                                                  final @NotNull HttpStatusCode status,
                                                                  final @NotNull WebRequest request) {
        final HttpStatus httpStatus = BAD_REQUEST;
        final String fieldParam = "<field>";

        final ExceptionArgumentNotValidOutDTO exception = ExceptionArgumentNotValidOutDTO.builder()
            .status(httpStatus)
            .message(getMessage("error.validation-failed"))
            .dateTime(now())
            .errors(ex.getBindingResult().getFieldErrors().stream()
                .map(error -> {
                    final AtomicReference<String> errorMessage = new AtomicReference<>(error.getDefaultMessage());
                    final AtomicReference<String> field = new AtomicReference<>();

                    if (nonNull(error.getDefaultMessage()) && error.getDefaultMessage().contains(fieldParam)) {
                        errorMessage.set(error.getDefaultMessage().split(fieldParam)[0]);
                        field.set(getMessage(error.getDefaultMessage().split(fieldParam)[1]));
                    }

                    return ExceptionArgumentNotValidOutDTO.ExceptionField.builder()
                        .field(field.get())
                        .message(errorMessage.get())
                        .build();
                })
                .toList())
            .build();

        return new ResponseEntity<>(exception, headers, httpStatus);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionOutDTO> dataIntegrityException(final DataIntegrityViolationException exception) {
        logException(exception);

        return ResponseEntity.status(BAD_REQUEST).body(
            ExceptionOutDTO.builder()
                .status(BAD_REQUEST)
                .message(exception.getMessage())
                .dateTime(now())
                .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionOutDTO> handleGlobalException(final Exception exception) {
        logException(exception);

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
            ExceptionOutDTO.builder()
                .status(INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .dateTime(now())
                .build());
    }

    private void logException(final Exception exception) {
        if (isFalse(enableStacktrace)) {
            log.error(exception.getMessage());
        } else {
            log.error(exception.getMessage(), exception);
        }
    }

}
