package com.acc.exception;

/*
 * InvalidExamDataException
 * ------------------------
 * This exception is thrown when the exam data provided is invalid.
 * Examples of invalid data include:
 * - Exam name is empty
 * - Duration is negative or zero
 * - Passing marks are greater than total marks
 * - Exam status or mode is empty
 */
public class InvalidExamDataException extends Exception {


    // Constructor with custom error message
    // Allows showing a detailed message about what is invalid
    public InvalidExamDataException(String message) {
        super(message);
    }
}
