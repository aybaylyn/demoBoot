package com.may.boot.exception;

import com.fasterxml.jackson.databind.deser.Deserializers;

/**
 * Created by May on 3/27/17.
 */
public class BaseException extends Exception {

    public BaseException(String message) {
        super(message);
    }
}
