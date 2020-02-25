package com.schionato.context;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionHandlerCastToHttpCode extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessageResponse(ex), BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorMessageResponse(ex), new HttpHeaders(), BAD_REQUEST, request);
    }

    @JsonAutoDetect(fieldVisibility = ANY)
    class ErrorMessageResponse {

        private final String message;

        ErrorMessageResponse(Exception ex) {
            this.message = ex.getMessage();
        }
    }

}

