package code.back.service.validation.validationRules;

import code.back.dto.RequestDto;

public interface ValidationRule {
    void validate(RequestDto requestDto);
}
