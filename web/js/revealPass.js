const togglePassword = document.querySelector("#togglePassword");
const password = document.querySelector("#password");

togglePassword.addEventListener("click", function () {
    // toggle the type attribute
    const typePassword = password.getAttribute("type") === "password" ? "text" : "password";
    password.setAttribute("type", typePassword);
    // toggle the icon
    this.classList.toggle("bi-eye");
});

function revealPass() {
    var op = document.getElementById("oldPass");
    var np1 = document.getElementById("newPass1");
    var np2 = document.getElementById("newPass2");
    if (op.type === "password") {
        op.type = "text";
    } else {
        op.type = "password";
    }
    if (np1.type === "password") {
        np1.type = "text";
    } else {
        np1.type = "password";
    }
    if (np2.type === "password") {
        np2.type = "text";
    } else {
        np2.type = "password";
    }
    toggle("bi-eye");
}

