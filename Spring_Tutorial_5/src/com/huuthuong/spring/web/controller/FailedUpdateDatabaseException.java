package com.huuthuong.spring.web.controller;

public class FailedUpdateDatabaseException extends Exception {

	public FailedUpdateDatabaseException() {}

    public FailedUpdateDatabaseException(String message) {
        super(message);
    }

    public FailedUpdateDatabaseException(Throwable cause) {
        super(cause);
    }

    public FailedUpdateDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
