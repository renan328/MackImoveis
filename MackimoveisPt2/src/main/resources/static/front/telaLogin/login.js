document.getElementById("form-login").addEventListener("submit", function (e) {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    // Simulação de verificação
    if (email === "teste@mack.com" && senha === "123456") {
        alert("Login realizado com sucesso!");
        // window.location.href = "pagina-principal.html"; // redireciona se quiser
    } else {
        alert("E-mail ou senha incorretos.");
    }

    this.reset();
});