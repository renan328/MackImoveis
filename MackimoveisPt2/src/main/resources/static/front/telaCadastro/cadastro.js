document.getElementById("form-cadastro").addEventListener("submit", function (e) {
    e.preventDefault();

    const dados = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value,
        propriedade: document.querySelector('input[name="propriedade"]:checked').value
    };

    console.log("Dados cadastrados:", dados);


    alert("Cadastro realizado com sucesso!");
    this.reset();
});