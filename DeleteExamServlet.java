package com.acc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.acc.entity.Exam;
import com.acc.service.ExamService;
import com.acc.dao.ExamServiceImpl;

@WebServlet("/DeleteExam")
public class DeleteExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ExamService examService = new ExamServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int examId = Integer.parseInt(request.getParameter("examId"));
            Exam exam = examService.getExamById(examId);

            if (exam == null) {
                request.setAttribute("error", "Exam ID not found!");
            } else {
                examService.deleteExam(examId);
                request.setAttribute("message", "Exam deleted successfully!");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error deleting exam: " + e.getMessage());
        }

        request.getRequestDispatcher("deleteExam.jsp").forward(request, response);
    }
}