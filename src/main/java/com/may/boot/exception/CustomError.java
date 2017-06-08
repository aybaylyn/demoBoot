package com.may.boot.exception;

/**
 * Created by May on 3/27/17.
 */
public class CustomError {

    private String message ;
    private int code ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CustomError(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
