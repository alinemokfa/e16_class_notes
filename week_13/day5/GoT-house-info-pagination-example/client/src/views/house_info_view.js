const HouseInfoView = function (container) {
  this.container = container;
}

HouseInfoView.prototype.render = function (houses) {
  this.container.innerHTML = '';
  houses.forEach(function (house) {
    const header = this.createHeader(house.name)
    const ul = this.createUnorderedList();
    this.createListItem('Region', house.region, ul);
    this.createListItem('Coat of Arms', house.coatOfArms, ul);
    this.createListItem('Words', house.words, ul);
    this.createListItem('Titles', house.titles.join(', '), ul);
  }.bind(this));
}

HouseInfoView.prototype.createHeader = function (name) {
  const h3 = document.createElement('h3');
  h3.innerText = name;
  this.container.appendChild(h3);
};

HouseInfoView.prototype.createUnorderedList = function () {
  const ul = document.createElement('ul');
  this.container.appendChild(ul);
  return ul;
}

HouseInfoView.prototype.createListItem = function (label, content, ul) {
  if (!content) return;
  const li = document.createElement('li');
  li.innerText = `${ label }: ${ content }`;
  ul.appendChild(li);
}

module.exports = HouseInfoView;
