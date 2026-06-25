package com.acc.exception;

/*
 * ExamNotFoundException
 * --------------------
 * This exception is thrown when a user tries to update, delete,
 * or fetch an exam that does not exist in the database.
 */
public class ExamNotFoundException extends Exception {


    // Constructor with custom error message
    // Allows showing a detailed message about the missing exam
    public ExamNotFoundException(String message) {
        super(message);
    }
}

