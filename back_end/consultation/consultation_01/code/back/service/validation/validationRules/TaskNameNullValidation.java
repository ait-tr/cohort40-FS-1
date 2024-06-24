package code.back.service.validation.validationRules;

import code.back.dto.RequestDto;
import code.back.service.validation.ValidationException;

public class TaskNameNullValidation implements ValidationRule{
    @Override
    public void validate(RequestDto requestDto) {
        if (requestDto.getName() == null) {
            throw new ValidationException("Task name must be not null");
        }
    }
}
