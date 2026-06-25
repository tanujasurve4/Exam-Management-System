package com.acc.entity;

import java.util.Date;

/*
 * Exam Entity Class
 * -----------------
 * Represents an Exam in the Exam Management System.
 * Holds all information about an exam like ID, name, mode, duration, marks, dates, and status.
 */

public class Exam {
	
	int examId; //Unique ID for each exam
	String examName; //eg.java test,mid semester exam
	String examMode; // Online / Offline 
	int duration; // Duration of in minutes 
	int totalMarks; //Total marks for the exam
	int passingMarks; //Min marks required to pass the exam
	Date startDate; //Exam start date
	Date endDate; //Exam end date
	String status; // Scheduled / Ongoing / Completed
	
	/*
     * Default constructor
     * Needed for creating objects without setting values immediately
     */
    public Exam() {}

    /*
     * Parameterized constructor
     * Initializes all details of the exam at once
     */
    public Exam(int examId, String examName, String examMode, int duration, int totalMarks, int passingMarks,
                Date startDate, Date endDate, String status) {
        super();
        this.examId = examId;
        this.examName = examName;
        this.examMode = examMode;
        this.duration = duration;
        this.totalMarks = totalMarks;
        this.passingMarks = passingMarks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    /*
     * Getter and Setter Methods
     * -------------------------
     * Used to protect data (Encapsulation) and safely read or update values
     */
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamMode() {
        return examMode;
    }

    public void setExamMode(String examMode) {
        this.examMode = examMode;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getPassingMarks() {
        return passingMarks;
    }

    public void setPassingMarks(int passingMarks) {
        this.passingMarks = passingMarks;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
     * toString() method
     * -----------------
     * Used to display exam details in a readable format
     * Helpful for debugging and printing information
     */
    @Override
    public String toString() {
        return examId + ", " + examName + ", " + examMode + ", " + duration + ", " 
               + totalMarks + ", " + passingMarks + ", " + startDate + ", " 
               + endDate + ", " + status;
    }

}