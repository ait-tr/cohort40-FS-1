package org.group40fs1project2.dto;

import java.util.List;

public class GeneralResponse <T> {
    T responseBody;
    List<String> errors;
}
