package com.acc.exception;

/*
 * DuplicateExamIdException
 * ------------------------
 * This exception is thrown when someone tries to add a new exam
 * but the exam ID they are using already exists in the database.
 */
public class DuplicateExamIdException extends Exception {

    // Constructor with custom error message
    public DuplicateExamIdException(String message) {
        super(message);
    }
}
