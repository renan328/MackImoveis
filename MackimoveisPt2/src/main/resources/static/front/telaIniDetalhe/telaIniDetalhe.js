async function carregarHotel() {
    try {
        // teste só para vê o css
        const hotel = {
            nome: "Hotel Copacabana Palace",
            local: "Rio de Janeiro - Copacabana",
            capacidade: "Até 3 pessoas",
            preco: "R$ 250,00",
            checkin: "10/01/2026",
            checkout: "10/01/2026",
            imagem: "../../imagens/hotel.jpg",
            descricao: "Localizado na icônica Praia de Copacabana, o Hotel Copacabana Palace oferece uma experiência luxuosa com vistas deslumbrantes do oceano. Com quartos elegantemente decorados, piscina ao ar livre, spa completo e uma variedade de opções gastronômicas, este hotel é perfeito para quem busca conforto e sofisticação no coração do Rio de Janeiro."
        };

        const detalhes = document.getElementById("hotel-detalhes");
        detalhes.innerHTML = `
      <img src="${hotel.imagem}" alt="${hotel.nome}" class="hotel-img">
      <div class="info">
        <h2>${hotel.nome}</h2>
        <p> <strong>${hotel.local}</strong></p>
        <p> ${hotel.capacidade}</p>
        <p class="preco"> <strong>${hotel.preco}</strong> <span>Por dia</span></p>
        <div class="datas">
          <p><strong>Data checkin</strong><br>${hotel.checkin}</p>
          <p><strong>Data checkout</strong><br>${hotel.checkout}</p>
        </div>
        <button class="reservar">Reservar</button>
      </div>
    `;

        const descricao = document.getElementById("descricao");
        descricao.innerHTML = `
      <h3>Descrição</h3>
      <p>${hotel.descricao}</p>
    `;
    } catch (erro) {
        console.error("Erro ao carregar hotel:", erro);
    }

    document.getElementById("btn-pesquisar").addEventListener("click", () => {
        const termo = document.getElementById("pesquisa").value.trim();
        console.log("Pesquisar por:", termo);

    });
}

carregarHotel();