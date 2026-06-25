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

@WebServlet("/UpdateExamStatus")
public class UpdateExamStatusServlet extends HttpServlet {
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
                String status = request.getParameter("status");
                examService.updateExamStatus(examId, status);
                request.setAttribute("message", "Exam status updated successfully!");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error updating status: " + e.getMessage());
        }

        request.getRequestDispatcher("updateStatus.jsp").forward(request, response);
    }
}