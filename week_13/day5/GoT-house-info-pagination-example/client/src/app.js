const HouseInfoView = require('./views/house_info_view.js');
const Ajax = require('./services/ajax.js');

const app = function () {
  const container = document.querySelector('#root');
  const houseInfoView = new HouseInfoView(container);
  let pageNumber = 1;

  const getHouses = function(pageNumber) {
    const url = `https://www.anapioficeandfire.com/api/houses?page=${pageNumber}&pageSize=5`;
    const ajax = new Ajax();
    ajax.get(url, function (data) {
      houseInfoView.render(data);
    });
  }

  const button = document.querySelector('#next-page');
  button.addEventListener('click', function() {
    pageNumber++;
    getHouses(pageNumber)
  });

  getHouses(pageNumber);
}

document.addEventListener('DOMContentLoaded', app);
