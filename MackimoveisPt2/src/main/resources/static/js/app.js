const API = {
    async get(url) {
        const res = await fetch(url);
        return res.json();
    },
    async post(url, body) {
        return fetch(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        });
    }
};

// Session helpers
function setUser(u) { sessionStorage.setItem('user', JSON.stringify(u)); }
function getUser() { return JSON.parse(sessionStorage.getItem('user') || 'null'); }
function logout() { sessionStorage.removeItem('user'); location.hash = '#/login'; }

// Home
async function renderHome() {


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
        // Adicione mais objetos conforme necessário
    ];

        const container = document.getElementById("properties-list") || document.getElementById("hotel-list");
        if (!container) return;

    // Renderiza cards estáticos de exemplo — substitua pela API quando pronto
    hotels.forEach(hotel => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
            <img src="/assets/imgs/${hotel.imagem}" alt="${hotel.nome}">
            <div class="card-body">
                <h3>${hotel.nome}</h3>
                <p>${hotel.local}</p>
                <p>Tipo: ${hotel.tipo}</p>
                <p>Capacidade: ${hotel.capacidade}</p>
                <p>${hotel.preco} por dia</p>
                <a class="btn" href="#">Ver mais</a>
            </div>`;
            container.appendChild(card);
    });

    // const container = document.querySelector('#properties-list');
    // let list = [];

    // try {
    //     list = await API.get('/api/propriedades/disponiveis');
    // } catch { list = []; }

    // if (list == []) {
    //     container.innerHTML = list.map(p => `
    //     <div class='card'>
    //         <img src='${p.imagemUrl || "/assets/img/default.jpg"}'>
    //         <div class='card-body'>
    //             <h3>${p.titulo}</h3>
    //             <p>${p.localizacao}</p>
    //             <p>R$ ${p.precoPorNoite}</p>
    //             <a class='btn' href='#/propriedade?id=${p.id}'>Ver mais</a>
    //         </div>
    //     </div>
    //   `).join('');
    // } else{
    //     container.innerHTML = "<h4>Sem propriedades</h4>"
    // }
}

// Login
async function handleLogin(e) {
    e.preventDefault();

    const email = document.querySelector('#email').value;
    const senha = document.querySelector('#senha').value;

    const res = await API.post('/api/usuarios/login', { email, senha });
    const data = await res.json();

    if (data.erro) {
        document.querySelector('#login-error').innerText = data.erro;
        return;
    }

    setUser(data);
    if (data.tipo === 'PROPRIETARIO') location.hash = '#/dashboard-proprietario';
    else location.hash = '#/dashboard-locatario';
}

// Cadastro
async function handleCadastro(e) {
    e.preventDefault();

    const nome = document.querySelector('#cad-nome').value;
    const email = document.querySelector('#cad-email').value;
    const senha = document.querySelector('#cad-senha').value;
    const tipo = document.querySelector('input[name="tipo"]:checked').value;

    const endpoint = tipo === 'PROPRIETARIO' ? '/api/usuarios/proprietario' : '/api/usuarios/inquilino';

    const res = await API.post(endpoint, { nome, email, senha });

    if (!res.ok) {
        document.querySelector('#cad-error').innerText = 'Erro ao cadastrar';
        return;
    }

    location.hash = '#/login';
}

// Detalhes da propriedade
async function renderPropertyDetail() {
    const params = new URLSearchParams(location.hash.split('?')[1]);
    const id = params.get('id');

    const p = await API.get('/api/propriedades/' + id);

    document.querySelector('#prop-title').innerText = p.titulo;
    document.querySelector('#prop-desc').innerText = p.descricao;
    document.querySelector('#prop-loc').innerText = p.localizacao;
    document.querySelector('#prop-price').innerText = 'R$ ' + p.precoPorNoite;
    document.querySelector('#reserve-btn').href = '#/reserva?id=' + p.id;
}

// Reserva
async function handleReserve(e) {
    e.preventDefault();

    const user = getUser();
    if (!user) { location.hash = '#/login'; return; }

    const params = new URLSearchParams(location.hash.split('?')[1]);
    const propriedadeId = params.get('id');

    const checkin = document.querySelector('#checkin').value;
    const checkout = document.querySelector('#checkout').value;

    const res = await API.post('/api/reservas', {
        propriedadeId,
        usuarioId: user.id,
        checkin,
        checkout
    });

    const data = await res.json();

    if (data.erro) {
        document.querySelector('#res-error').innerText = data.erro;
        return;
    }

    document.querySelector('#res-success').innerText = 'Reserva realizada! Total: R$ ' + data.custoTotal;
}

// Dashboard Proprietário
async function loadDashboardProprietario() {
    const user = getUser();
    if (!user) { location.hash = '#/login'; return; }

    let props = await API.get('/api/propriedades');
    props = props.filter(p => p.proprietario && p.proprietario.id === user.id);

    const list = props.map(p => `<li>${p.titulo} — ${p.disponivel ? 'Disponível' : 'Alugada'}</li>`).join('');

    document.querySelector('#owner-list').innerHTML = '<ul>' + list + '</ul>';
}

// Dashboard Locatário
async function loadDashboardLocatario() {
    const user = getUser();
    if (!user) { location.hash = '#/login'; return; }

    const res = await API.get('/api/reservas/usuario/' + user.id);

    const list = res.map(r => `<li>${r.propriedade.titulo} — ${r.checkin} até ${r.checkout} — R$ ${r.custoTotal}</li>`).join('');

    document.querySelector('#tenant-list').innerHTML = '<ul>' + list + '</ul>';
}

// Cad propriedade
async function handleCadastroPropriedade(e) {
    e.preventDefault();
    const user = getUser();
    if (!user || user.tipo !== 'PROPRIETARIO') {
        document.querySelector('#prop-error').innerText = 'Apenas proprietários podem cadastrar propriedades.';
        return;
    }

    const body = {
        titulo: document.querySelector('#prop-titulo').value,
        descricao: document.querySelector('#prop-desc').value,
        localizacao: document.querySelector('#prop-loc').value,
        capacidade: document.querySelector('#prop-cap').value,
        precoPorNoite: document.querySelector('#prop-preco').value,
        proprietarioId: user.id
    };

    const res = await API.post('/api/propriedades', body);

    if (!res.ok) {
        document.querySelector('#prop-error').innerText = 'Erro ao cadastrar propriedade';
        return;
    }

    document.querySelector('#prop-success').innerText = 'Propriedade cadastrada com sucesso!';
}