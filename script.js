function validateExamForm() {
    let duration = document.forms["examForm"]["duration"].value;
    let total = document.forms["examForm"]["totalMarks"].value;
    let pass = document.forms["examForm"]["passingMarks"].value;

    if (duration <= 0) {
        alert("Duration must be positive");
        return false;
    }
    if (pass > total) {
        alert("Passing marks cannot exceed total marks");
        return false;
    }
    return true;
}