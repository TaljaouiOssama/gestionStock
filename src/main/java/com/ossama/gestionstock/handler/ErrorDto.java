package com.ossama.gestionstock.handler;

import com.ossama.gestionstock.exception.ErrorsCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorsCode errorCode;
    private String message;
    private List<String> errors=new ArrayList<>();
}
