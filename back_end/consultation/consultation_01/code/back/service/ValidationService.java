package code.back.service;

import code.back.dto.RequestDto;
import code.back.service.validation.ValidationException;
import code.back.service.validation.validationRules.CodeError;
import code.back.service.validation.validationRules.ValidationRule;

import java.util.ArrayList;
import java.util.List;

public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CodeError> validation(RequestDto request){
        List<CodeError> errors = new ArrayList<>();

        if (request == null) {
            errors.add(new CodeError("Task request must be not null"));
            return errors;
        }

        for (ValidationRule rule : validationRules){
            try {
            rule.validate(request);
            } catch (ValidationException e){
                errors.add(new CodeError(e.getMessage()));
            }
        }

        return errors;
    }

}
