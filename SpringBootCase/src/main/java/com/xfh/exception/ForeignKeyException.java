package com.xfh.exception;





public class ForeignKeyException extends RuntimeException {
    public ForeignKeyException() {
    }
    public ForeignKeyException(String message) {
        super(message);
    }

}
