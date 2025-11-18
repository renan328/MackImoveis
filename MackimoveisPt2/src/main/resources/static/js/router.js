const routes = {
  '': '/Pages/Home.html',
  '#/': '/Pages/Home.html',
  '#/login': '/Pages/Login.html',
  '#/cadastro': '/Pages/Cadastro.html',
  '#/dashboard-proprietario': '/Pages/CadPropriedade.html',
  '#/dashboard-locatario': '/Pages/Home.html',
  '#/propriedade': '/Pages/propriedade-detalhe.html',
  '#/reserva': '/Pages/Reserva.html'
};

async function router() {
  const raw = location.hash || '#/'
  const hash = raw.split('?')[0]
  const path = routes[hash] || routes['#/']

  try {
    const html = await fetch(path).then(r => r.text());
    document.querySelector('#app').innerHTML = html;

    const scripts = document.querySelector('#app').querySelectorAll('script');
    scripts.forEach(s => { try { eval(s.innerText); } catch(e) {} });

  } catch (e) {
    document.querySelector('#app').innerHTML = '<p>Erro ao carregar</p>'; 
  }
}

window.addEventListener('hashchange', router);
window.addEventListener('load', router);