package com.acc.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.acc.entity.Exam;
import com.acc.service.ExamService;
import com.acc.dao.ExamServiceImpl;

@WebServlet("/UpdateExamDates")
public class UpdateExamDatesServlet extends HttpServlet {
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
                Date startDate = Date.valueOf(request.getParameter("startDate"));
                Date endDate = Date.valueOf(request.getParameter("endDate"));
                examService.updateExamDates(examId, startDate, endDate);
                request.setAttribute("message", "Exam dates updated successfully!");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error updating dates: " + e.getMessage());
        }

        request.getRequestDispatcher("updateDates.jsp").forward(request, response);
    }
}