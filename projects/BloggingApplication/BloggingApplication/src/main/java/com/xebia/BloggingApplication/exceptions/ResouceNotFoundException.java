package com.xebia.BloggingApplication.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResouceNotFoundException extends RuntimeException{
    String resouceName;
    String fieldName;
    long fieldValue;

    public ResouceNotFoundException(String resouceName,String fieldName,long fieldValue){
        super(String.format("%s is not found with %s: %s",resouceName,fieldName,fieldValue));
        this.fieldName = fieldName;
        this.resouceName = resouceName;
        this.fieldValue = fieldValue;
    }


}
