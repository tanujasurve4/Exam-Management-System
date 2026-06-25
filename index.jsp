<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exam Management System</title>
    <!-- Bootstrap 5 CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #00c6ff, #0072ff); /* beautiful gradient */
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.8rem;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.3);
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 25px rgba(0,0,0,0.4);
        }
        .btn-operation {
            width: 200px;
            margin: 15px;
            font-weight: bold;
            border-radius: 50px;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .btn-operation:hover {
            transform: scale(1.1);
            box-shadow: 0 8px 15px rgba(0,0,0,0.3);
        }
        .welcome-text {
            font-size: 1.3rem;
            color: #333;
        }
        .icon {
            font-size: 1.2rem;
            margin-right: 8px;
        }
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
                <li class="nav-item"><a class="nav-link" href="addExam.jsp"><i class="fas fa-plus icon"></i>Add Exam</a></li>
                <li class="nav-item"><a class="nav-link" href="viewExams.jsp"><i class="fas fa-table icon"></i>View All Exams</a></li>
                <li class="nav-item"><a class="nav-link" href="updateDates.jsp"><i class="fas fa-calendar-day icon"></i>Update Dates</a></li>
                <li class="nav-item"><a class="nav-link" href="updateStatus.jsp"><i class="fas fa-sync-alt icon"></i>Update Status</a></li>
                <li class="nav-item"><a class="nav-link" href="deleteExam.jsp"><i class="fas fa-trash-alt icon"></i>Delete Exam</a></li>
                <li class="nav-item"><a class="nav-link" href="viewExam.jsp"><i class="fas fa-search icon"></i>View Exam By ID</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container text-center mt-5">
    <div class="card p-5 bg-light">
        <h1 class="card-title mb-4" style="color: #0072ff;">Welcome to the Exam Management System</h1>
        <p class="welcome-text mb-5">Easily manage all your exams: add new exams, update dates, change status, delete exams, and view all exam details in one place.</p>

        <div class="d-flex flex-wrap justify-content-center">
            <a href="addExam.jsp" class="btn btn-gradient btn-success btn-operation"><i class="fas fa-plus icon"></i>Add Exam</a>
            <a href="viewExams.jsp" class="btn btn-gradient btn-info btn-operation"><i class="fas fa-table icon"></i>View All Exams</a>
            <a href="updateDates.jsp" class="btn btn-gradient btn-warning btn-operation"><i class="fas fa-calendar-day icon"></i>Update Dates</a>
            <a href="updateStatus.jsp" class="btn btn-gradient btn-secondary btn-operation"><i class="fas fa-sync-alt icon"></i>Update Status</a>
            <a href="deleteExam.jsp" class="btn btn-gradient btn-danger btn-operation"><i class="fas fa-trash-alt icon"></i>Delete Exam</a>
            <a href="viewExam.jsp" class="btn btn-gradient btn-primary btn-operation"><i class="fas fa-search icon"></i>View Exam By ID</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>