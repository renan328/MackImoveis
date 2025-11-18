// só para testar como ta o css

const hotels = [
    {
        nome: "Hotel Copacabana Palace",
        local: "Rio de Janeiro - Copacabana",
        tipo: "Hotel",
        capacidade: "Até 3 pessoas",
        preco: "R$ 250,00",
        imagem: "hotel1.jpg"
    },
    {
        nome: "Hotel Copacabana Palace",
        local: "Rio de Janeiro - Copacabana",
        tipo: "Hotel",
        capacidade: "Até 3 pessoas",
        preco: "R$ 250,00",
        imagem: "hotel2.jpg"
    },
    // Adicione mais se quiser depois
];

const hotelList = document.getElementById("hotel-list");

hotels.forEach(hotel => {
    const card = document.createElement("div");
    card.className = "hotel-card";
    card.innerHTML = `
    <img src="${hotel.imagem}" alt="${hotel.nome}">
    <h2>${hotel.nome}</h2>
    <p> ${hotel.local}</p>
    <p> Tipo: ${hotel.tipo}</p>
    <p> Capacidade: ${hotel.capacidade}</p>
    <p> ${hotel.preco} por dia</p>
    <button class="details-button">Ver detalhes</button>
  `;
    hotelList.appendChild(card);
});
// tem que revisar pq não sei se ta gg
// nem sei se é aqui que fica mesmo
document.getElementById("btn-pesquisar").addEventListener("click", () => {
    const termo = document.getElementById("pesquisa").value.trim();
    console.log("Pesquisar por:", termo);

    // filtra os hoteis
});