// Set today's date as the max for the DOB field
document.addEventListener("DOMContentLoaded", function () {
    let today = new Date();
    let month = today.getMonth() + 1;
    let year = today.getFullYear();
    let date = today.getDate();

    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;

    let maxDate = `${year}-${month}-${date}`;
    document.getElementById("dob").setAttribute("max", maxDate);
});

// Registration validation
function registation() {
    const name = document.getElementById('name').value.trim();
    const username = document.getElementById('username').value.trim();
    const contact = document.getElementById('contact').value.trim();
    const email = document.getElementById('email').value.trim();
    const dob = document.getElementById('dob').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.querySelector('.con-password').value.trim();

    const namePattern = /^[a-zA-Z\s]+$/;
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (name === "" || !namePattern.test(name)) {
        alert("Please enter a valid name (letters only).");
        return false;
    }

    if (username === "") {
        alert("Username is required.");
        return false;
    }

    if (!/^[0-9]{10}$/.test(contact)) {
        alert("Enter a valid 10-digit contact number.");
        return false;
    }

    if (email === "" || !emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    if (dob === "") {
        alert("Please select your date of birth.");
        return false;
    }

    if (password === "") {
        alert("Password is required.");
        return false;
    }

    if (password !== confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }

    if (password.length < 8) {
        alert("Password must be at least 8 characters long.");
        return false;
    }

    if (confirm("Registration successful! Go to the Home page and Log In?")) {
        // Optionally redirect here
        return true;
    }

    return false;
}
