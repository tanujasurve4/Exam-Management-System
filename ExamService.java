package com.acc.service;

import java.util.List;

import java.sql.Date;

import com.acc.entity.Exam;

/*
 * ExamService Interface
 * ---------------------
 * This interface defines the basic actions we can perform on exams:
 * 1. Add a new exam
 * 2. Delete an existing exam
 * 3. Get all exams or get exam by ID
 * 4. Update exam status or exam dates
 */
public interface ExamService {

    /*
     * Add a new exam
     * Takes an Exam object and saves it to the database.
     */
    public void addExam(Exam exam);

    /*
     * Delete an exam by ID
     * Removes an exam from the database using its examId.
     */
    public void deleteExam(int examId);

    /*
     * Get all exams
     * Returns a list of all exams in the database.
     */
    public List<Exam> getAllExams();

    /*
     * Get exam by ID
     * Returns the Exam object for a given examId.
     */
    public Exam getExamById(int examId);

    /*
     * Update exam status
     * Change the status of an exam (Scheduled, Ongoing, Completed).
     */
    public void updateExamStatus(int examId, String status);

    /*
     * Update exam dates
     * Update only the start and end dates of an exam.
     */
    public void updateExamDates(int examId, Date startDate, Date endDate);
}

