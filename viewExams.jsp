<%@ page import="java.util.*, com.acc.entity.Exam, com.acc.dao.ExamServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View All Exams</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
<style>
body {background: linear-gradient(to right, #43e97b, #38f9d7); font-family: 'Segoe UI', sans-serif;}
.card {border-radius: 15px; margin-top: 50px; box-shadow: 0 8px 20px rgba(0,0,0,0.3);}
.table thead {background-color: #007bff; color: white;}
.table td, .table th {vertical-align: middle;}
.navbar-brand {font-weight: bold;}
</style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
<div class="container">
<a class="navbar-brand" href="index.jsp">Exam Management System</a>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
<ul class="navbar-nav">
<li class="nav-item"><a class="nav-link" href="addExam.jsp"><i class="fas fa-plus"></i> Add Exam</a></li>
<li class="nav-item"><a class="nav-link active" href="viewExams.jsp"><i class="fas fa-table"></i> View All Exams</a></li>
<li class="nav-item"><a class="nav-link" href="updateDates.jsp"><i class="fas fa-calendar-day"></i> Update Dates</a></li>
<li class="nav-item"><a class="nav-link" href="updateStatus.jsp"><i class="fas fa-sync-alt"></i> Update Status</a></li>
<li class="nav-item"><a class="nav-link" href="deleteExam.jsp"><i class="fas fa-trash-alt"></i> Delete Exam</a></li>
<li class="nav-item"><a class="nav-link" href="viewExam.jsp"><i class="fas fa-search"></i> View Exam By ID</a></li>
</ul>
</div>
</div>
</nav>

<!-- Table -->
<div class="container">
<div class="card p-4 bg-light">
<h2 class="mb-4 text-success text-center"><i class="fas fa-table"></i> All Exams</h2>

<%
    ExamServiceImpl service = new ExamServiceImpl();
    List<Exam> exams = service.getAllExams();
    if (exams == null || exams.isEmpty()) {
%>
<div class="alert alert-warning text-center">No exams found!</div>
<%
    } else {
%>
<div class="table-responsive">
<table class="table table-striped table-hover text-center">
<thead>
<tr>
<th>Exam ID</th>
<th>Name</th>
<th>Mode</th>
<th>Duration</th>
<th>Total Marks</th>
<th>Passing Marks</th>
<th>Start Date</th>
<th>End Date</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<%
    for(Exam e : exams){
%>
<tr>
<td><%= e.getExamId() %></td>
<td><%= e.getExamName() %></td>
<td><%= e.getExamMode() %></td>
<td><%= e.getDuration() %></td>
<td><%= e.getTotalMarks() %></td>
<td><%= e.getPassingMarks() %></td>
<td><%= e.getStartDate() %></td>
<td><%= e.getEndDate() %></td>
<td><%= e.getStatus() %></td>
</tr>
<% } %>
</tbody>
</table>
</div>
<% } %>

</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>