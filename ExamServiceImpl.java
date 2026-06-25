package com.acc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acc.entity.Exam;
import com.acc.service.ExamService;
import com.acc.util.DBConnection;

/**
 * ExamServiceImpl
 * Implements all database operations for "exam" table.
 */
public class ExamServiceImpl implements ExamService {

    /**
     * Add a new exam to the database
     */
    @Override
    public void addExam(Exam exam) {
        String sql = "INSERT INTO exam (exam_id, exam_name, exam_mode, duration, total_marks, passing_marks, start_date, end_date, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, exam.getExamId());
            pstmt.setString(2, exam.getExamName());
            pstmt.setString(3, exam.getExamMode());
            pstmt.setInt(4, exam.getDuration());
            pstmt.setInt(5, exam.getTotalMarks());
            pstmt.setInt(6, exam.getPassingMarks());
            pstmt.setDate(7, new Date(exam.getStartDate().getTime()));
            pstmt.setDate(8, new Date(exam.getEndDate().getTime()));
            pstmt.setString(9, exam.getStatus());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete an exam by ID
     */
    @Override
    public void deleteExam(int examId) {
        String sql = "DELETE FROM exam WHERE exam_id=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, examId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all exams
     */
    @Override
    public List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList<>();
        String sql = "SELECT * FROM exam";

        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Exam exam = new Exam(
                        rs.getInt("exam_id"),
                        rs.getString("exam_name"),
                        rs.getString("exam_mode"),
                        rs.getInt("duration"),
                        rs.getInt("total_marks"),
                        rs.getInt("passing_marks"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                );
                exams.add(exam);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    /**
     * Get a single exam by ID
     */
    @Override
    public Exam getExamById(int examId) {
        Exam exam = null;
        String sql = "SELECT * FROM exam WHERE exam_id=?";

        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, examId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exam = new Exam(
                            rs.getInt("exam_id"),
                            rs.getString("exam_name"),
                            rs.getString("exam_mode"),
                            rs.getInt("duration"),
                            rs.getInt("total_marks"),
                            rs.getInt("passing_marks"),
                            rs.getDate("start_date"),
                            rs.getDate("end_date"),
                            rs.getString("status")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }

    /**
     * Update exam status
     */
    @Override
    public void updateExamStatus(int examId, String status) {
        String sql = "UPDATE exam SET status=? WHERE exam_id=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, examId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update exam start and end dates
     */
    @Override
    public void updateExamDates(int examId, Date startDate, Date endDate) {
        String sql = "UPDATE exam SET start_date=?, end_date=? WHERE exam_id=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setDate(1, startDate);
            pstmt.setDate(2, endDate);
            pstmt.setInt(3, examId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}