package com.acc;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.acc.entity.Exam;
import com.acc.exception.DuplicateExamIdException;
import com.acc.exception.ExamNotFoundException;
import com.acc.exception.InvalidExamDataException;
import com.acc.service.ExamService;
import com.acc.dao.ExamServiceImpl;

public class ExamManager {

    static ExamService examService = new ExamServiceImpl();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
        	
            System.out.println("\n----- EXAM MANAGER OPTIONS -----");
            System.out.println("1. Add Exam");
            System.out.println("2. Update Exam Dates by ID");
            System.out.println("3. Delete Exam");
            System.out.println("4. View All Exams");
            System.out.println("5. View Exam By ID");
            System.out.println("6. Change Exam Status by ID");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt(); 
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1: // Add Exam
                    try {
                        System.out.print("Enter Exam ID: ");
                        int id = sc.nextInt(); sc.nextLine();

                        if (examService.getExamById(id) != null) {
                            throw new DuplicateExamIdException("Exam ID already exists.");
                        }

                        System.out.print("Enter Exam Name: ");
                        String name = sc.nextLine();
                        if (name == null || name.equals("")) {
                            throw new InvalidExamDataException("Exam name cannot be empty");
                        }

                        System.out.print("Enter Exam Mode (Online/Offline): ");
                        String mode = sc.nextLine();
                        if (mode == null || mode.equals("")) {
                            throw new InvalidExamDataException("Exam mode cannot be empty");
                        }

                        System.out.print("Enter Duration (minutes): ");
                        int duration = sc.nextInt(); sc.nextLine();
                        if (duration <= 0) throw new InvalidExamDataException("Duration must be positive");

                        System.out.print("Enter Total Marks: ");
                        int total = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Passing Marks: ");
                        int pass = sc.nextInt(); sc.nextLine();
                        if (pass > total) throw new InvalidExamDataException("Passing marks cannot exceed total marks");

                        System.out.print("Enter Status (Scheduled/Ongoing/Completed): ");
                        String status = sc.nextLine();
                        if (status == null || status.equals("")) {
                            throw new InvalidExamDataException("Status cannot be empty");
                        }

                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        String start = sc.nextLine();
                        if (start == null || start.equals("")) {
                            throw new InvalidExamDataException("Start date cannot be empty");
                        }

                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        String end = sc.nextLine();
                        if (end == null || end.equals("")) {
                            throw new InvalidExamDataException("End date cannot be empty");
                        }

                        Date startDate = Date.valueOf(start);
                        Date endDate = Date.valueOf(end);

                        Exam exam = new Exam(id, name, mode, duration, total, pass, startDate, endDate, status);
                        examService.addExam(exam);
                        System.out.println("Exam added successfully.");

                        System.out.println("Current Exams:");
                        List<Exam> examsAfterAdd = examService.getAllExams();
                        for (Exam e : examsAfterAdd) System.out.println(e);

                    } catch (DuplicateExamIdException | InvalidExamDataException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Update Exam Dates
                    try {
                        System.out.print("Enter Exam ID to update dates: ");
                        int eid = sc.nextInt(); sc.nextLine();

                        Exam examToUpdate = examService.getExamById(eid);
                        if (examToUpdate == null) throw new ExamNotFoundException("Exam with given ID does not exist.");

                        System.out.print("Enter new Start Date (YYYY-MM-DD): ");
                        String start1 = sc.nextLine();
                        if (start1 == null || start1.equals("")) {
                            throw new InvalidExamDataException("Start date cannot be empty");
                        }

                        System.out.print("Enter new End Date (YYYY-MM-DD): ");
                        String end1 = sc.nextLine();
                        if (end1 == null || end1.equals("")) {
                            throw new InvalidExamDataException("End date cannot be empty");
                        }

                        Date newStart = Date.valueOf(start1);
                        Date newEnd = Date.valueOf(end1);

                        examService.updateExamDates(eid, newStart, newEnd);
                        System.out.println("Exam dates updated successfully.");

                        System.out.println("Current Exams:");
                        List<Exam> examsAfterUpdate = examService.getAllExams();
                        for (Exam e : examsAfterUpdate) System.out.println(e);

                    } catch (ExamNotFoundException | InvalidExamDataException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3: // Delete Exam
                    try {
                        System.out.print("Enter Exam ID to delete: ");
                        int delId = sc.nextInt(); sc.nextLine();

                        Exam examToDelete = examService.getExamById(delId);
                        if (examToDelete == null) throw new ExamNotFoundException("Exam with given ID does not exist.");

                        examService.deleteExam(delId);
                        System.out.println("Exam deleted successfully.");

                        System.out.println("Current Exams:");
                        List<Exam> examsAfterDelete = examService.getAllExams();
                        for (Exam e : examsAfterDelete) System.out.println(e);

                    } catch (ExamNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4: // View All Exams
                    List<Exam> allExams = examService.getAllExams();
                    if (allExams.isEmpty()) System.out.println("No exams found.");
                    else for (Exam e : allExams) System.out.println(e);
                    break;

                case 5: // View Exam By ID
                    try {
                        System.out.print("Enter Exam ID to view: ");
                        int viewId = sc.nextInt(); sc.nextLine();

                        Exam examToView = examService.getExamById(viewId);
                        if (examToView == null) throw new ExamNotFoundException("Exam with given ID does not exist.");

                        System.out.println(examToView);

                    } catch (ExamNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6: // Change Exam Status
                    try {
                        System.out.print("Enter Exam ID to change status: ");
                        int stId = sc.nextInt(); sc.nextLine();

                        Exam examToChangeStatus = examService.getExamById(stId);
                        if (examToChangeStatus == null) throw new ExamNotFoundException("Exam with given ID does not exist.");

                        System.out.print("Enter new Status: ");
                        String newStatus = sc.nextLine();
                        if (newStatus == null || newStatus.equals("")) {
                            throw new InvalidExamDataException("Status cannot be empty");
                        }

                        examService.updateExamStatus(stId, newStatus);
                        System.out.println("Exam status updated successfully.");

                        System.out.println("Current Exams:");
                        List<Exam> examsAfterStatus = examService.getAllExams();
                        for (Exam e : examsAfterStatus) System.out.println(e);

                    } catch (ExamNotFoundException | InvalidExamDataException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Exit....");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1–7.");
            }

        } while (choice != 7);

        sc.close();
    }
}



