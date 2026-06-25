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

@WebServlet("/AddExam")
public class AddExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ExamService examService = new ExamServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("examId"));
            String name = request.getParameter("name");
            String mode = request.getParameter("mode");
            int duration = Integer.parseInt(request.getParameter("duration"));
            int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));
            int passingMarks = Integer.parseInt(request.getParameter("passingMarks"));
            String status = request.getParameter("status");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));

            Exam exam = new Exam(id, name, mode, duration, totalMarks, passingMarks, startDate, endDate, status);
            examService.addExam(exam);

            request.setAttribute("message", "Exam added successfully!");
        } catch (Exception e) {
            request.setAttribute("error", "Error adding exam: " + e.getMessage());
        }

        request.getRequestDispatcher("addExam.jsp").forward(request, response);
    }
}