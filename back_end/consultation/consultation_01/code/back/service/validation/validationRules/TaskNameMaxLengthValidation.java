package code.back.service.validation.validationRules;

import code.back.dto.RequestDto;
import code.back.service.validation.ValidationException;

public class TaskNameMaxLengthValidation implements ValidationRule{
    @Override
    public void validate(RequestDto requestDto) {
        if (requestDto.getName().length() > 30) {
            throw new ValidationException("Task name length must be less than 30 characters");
        }
    }
}
