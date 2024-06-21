package code.backEnd.dto;

public class RequestDto {
    private String name;
    private String description;

    public RequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
