package com.may.boot.exception;

import com.fasterxml.jackson.databind.deser.Deserializers;

/**
 * Created by May on 3/27/17.
 */
public class MyException2 extends BaseException {
    public MyException2(String message) {
        super(message);
    }
}
