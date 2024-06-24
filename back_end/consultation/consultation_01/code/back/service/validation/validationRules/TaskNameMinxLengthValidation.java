package code.back.service.validation.validationRules;

import code.back.dto.RequestDto;
import code.back.service.validation.ValidationException;

public class TaskNameMinxLengthValidation implements ValidationRule{
    @Override
    public void validate(RequestDto requestDto) {
        if (requestDto.getName().length() < 5) {
            throw new ValidationException("Task name length must be greater than 5 characters, but actual name length is " + requestDto.getName().length());
        }
    }
}
