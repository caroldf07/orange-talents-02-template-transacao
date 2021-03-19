package br.com.orangetalents.compartilhado.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ExceptionGenerico extends RuntimeException {
    private final HttpStatus httpStatus;

    private final String reason;

    public ExceptionGenerico(HttpStatus httpStatus, String reason) {
        super(reason);
        this.httpStatus = httpStatus;
        this.reason = reason;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getReason() {
        return reason;
    }
}
