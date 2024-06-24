package code.back.service.validation.validationRules;

import java.util.Objects;

public class CodeError {
    private String message;

    public CodeError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeError codeError = (CodeError) o;
        return Objects.equals(message, codeError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }

    @Override
    public String toString() {
        return "CodeError{" +
                "message='" + message + '\'' +
                '}';
    }
}
