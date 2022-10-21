package com.ossama.gestionstock.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException{
    private ErrorsCode errorCode;
    public EntityNotFoundException(String message){
        super(message);
    }
    public EntityNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public EntityNotFoundException(String message,Throwable cause,ErrorsCode errorCode){
        super(message,cause);
        this.errorCode=errorCode;
    }
    public EntityNotFoundException(String message,ErrorsCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
