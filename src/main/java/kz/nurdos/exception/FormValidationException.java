package kz.nurdos.exception;

import org.springframework.validation.BindingResult;

public class FormValidationException extends RuntimeException {
    private final BindingResult bindingResult;
    public FormValidationException(BindingResult bindingResult) {
        super("Validation failed");
        this.bindingResult = bindingResult;
    }
}
