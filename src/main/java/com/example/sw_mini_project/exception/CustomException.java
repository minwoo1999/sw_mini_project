package com.example.sw_mini_project.exception;


public class CustomException extends RuntimeException {

    //객체를 구분할 떄!! serialvseionUID


    public CustomException(String message) {
        super(message);
    }

}
