package com.example.sw_mini_project.exception;


import java.util.Map;

public class CustomVaildationApiException extends RuntimeException {

    //객체를 구분할 떄!! serialvseionUID
    private Map<String,String> errorMap;


    public CustomVaildationApiException(String message) {
        super(message);
    }

    public CustomVaildationApiException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
    public Map<String,String> getErrorMap(){
        return errorMap;
    }
}
