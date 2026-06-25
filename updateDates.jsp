<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Exam Dates</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
<style>
body {background: linear-gradient(to right, #ffecd2, #fcb69f); font-family: 'Segoe UI', sans-serif;}
.card {border-radius: 15px; margin-top: 50px; box-shadow: 0 8px 20px rgba(0,0,0,0.3);}
.btn-submit {width: 180px; font-weight: bold; border-radius: 50px;}
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
<li class="nav-item"><a class="nav-link" href="viewExams.jsp"><i class="fas fa-table"></i> View All Exams</a></li>
<li class="nav-item"><a class="nav-link active" href="updateDates.jsp"><i class="fas fa-calendar-day"></i> Update Dates</a></li>
<li class="nav-item"><a class="nav-link" href="updateStatus.jsp"><i class="fas fa-sync-alt"></i> Update Status</a></li>
<li class="nav-item"><a class="nav-link" href="deleteExam.jsp"><i class="fas fa-trash-alt"></i> Delete Exam</a></li>
<li class="nav-item"><a class="nav-link" href="viewExam.jsp"><i class="fas fa-search"></i> View Exam By ID</a></li>
</ul>
</div>
</div>
</nav>

<!-- Form -->
<div class="container">
<div class="card p-5 bg-light">
<h2 class="mb-4 text-warning text-center"><i class="fas fa-calendar-day"></i> Update Exam Dates</h2>

<!-- ✅ Corrected form action -->
<form action="UpdateExamDates" method="post">
<div class="mb-3">
<label>Exam ID</label>
<input type="number" name="examId" class="form-control" required>
</div>
<div class="mb-3">
<label>New Start Date</label>
<input type="date" name="startDate" class="form-control" required>
</div>
<div class="mb-3">
<label>New End Date</label>
<input type="date" name="endDate" class="form-control" required>
</div>

<!-- Display success/error messages -->
<% if (request.getAttribute("message") != null) { %>
<div class="alert alert-success mt-3"><%= request.getAttribute("message") %></div>
<% } %>
<% if (request.getAttribute("error") != null) { %>
<div class="alert alert-danger mt-3"><%= request.getAttribute("error") %></div>
<% } %>

<div class="text-center">
<button type="submit" class="btn btn-warning btn-submit"><i class="fas fa-save"></i> Update Dates</button>
</div>
</form>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>