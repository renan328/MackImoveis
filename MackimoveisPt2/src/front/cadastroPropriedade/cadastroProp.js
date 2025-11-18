document.getElementById("form-propriedade").addEventListener("submit", function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    const dados = {
        nome: formData.get("nome"),
        email: formData.get("email"),
        endereco: formData.get("endereco"),
        capacidade: formData.get("capacidade"),
        valor: formData.get("valor"),
        senha: formData.get("senha"),
        imagem: formData.get("imagem")?.name || "sem-imagem"
    };

    console.log("Propriedade cadastrada:", dados);

    alert("Cadastro de propriedade realizado com sucesso!");
    this.reset();
});