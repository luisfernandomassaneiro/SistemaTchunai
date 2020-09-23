package br.com.senior.tchunai.lib.business.application.commom.exceptions;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class BusinessException extends RuntimeException {

    @Getter
    private final transient Set<ConstraintViolation<?>> violations;

    public BusinessException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        violations = null;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        violations = null;
    }

    public BusinessException(String message) {
        super(message);
        violations = null;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        violations = null;
    }

    public BusinessException(Set<ConstraintViolation<?>> violations) {
        this.violations = violations;
    }

    public BusinessException(Set<ConstraintViolation<?>> violations, Throwable cause) {
        super(cause);
        this.violations = violations;
    }
}
