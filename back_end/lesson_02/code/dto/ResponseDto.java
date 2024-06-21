package code.dto;

import java.util.List;

public class ResponseDto <T> {
    private Integer responseCode;
    private T result;
    private List<String> errors;

    public ResponseDto(Integer responseCode, T result, List<String> errors) {
        this.responseCode = responseCode;
        this.result = result;
        this.errors = errors;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public T getResult() {
        return result;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "responseCode=" + responseCode +
                ", result=" + result +
                ", errors=" + errors +
                '}';
    }
}
