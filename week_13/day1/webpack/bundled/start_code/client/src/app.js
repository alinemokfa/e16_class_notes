const getFilms = require('./models/films.js');
const UI = require('./views/ui');

const app = function () {
  const container = document.querySelector('#films');
  const ui = new UI(container);

  const films = getFilms();
  ui.render(films);
}

document.addEventListener('DOMContentLoaded', app);
