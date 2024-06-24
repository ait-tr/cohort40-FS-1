package code.back.service.validation.validationRules;

import code.back.dto.RequestDto;
import code.back.service.validation.ValidationException;

public class TaskDescriptionNullValidation implements ValidationRule{
    @Override
    public void validate(RequestDto requestDto) {
        if (requestDto.getDescription() == null) {
            throw new ValidationException("Task description must be not null");
        }
    }
}
