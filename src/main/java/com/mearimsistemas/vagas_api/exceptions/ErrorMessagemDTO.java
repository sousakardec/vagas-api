package com.mearimsistemas.vagas_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessagemDTO {
    private String message;
    private String field;
}
