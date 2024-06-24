package code.back.dto;

import code.back.service.validation.validationRules.CodeError;

import java.util.List;

public class ResponseDto<T>{
    private T result;
    private List<CodeError> errors;

    public ResponseDto(T result, List<CodeError> errors) {
        this.result = result;
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public List<CodeError> getErrors() {
        return errors;
    }
}
