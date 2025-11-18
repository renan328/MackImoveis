const routes = {
  '': '/pages/home.html',
  '#/': '/pages/home.html',
  '#/login': '/pages/login.html',
  '#/cadastro': '/pages/cadastro.html',
  '#/dashboard-proprietario': '/pages/dashboard-proprietario.html',
  '#/dashboard-locatario': '/pages/dashboard-locatario.html',
  '#/propriedade': '/pages/propriedade-detalhe.html',
  '#/reserva': '/pages/reserva.html'
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