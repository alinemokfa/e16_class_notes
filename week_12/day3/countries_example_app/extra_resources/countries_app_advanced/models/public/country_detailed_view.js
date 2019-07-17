var CountryDetailView = function (container) {
  this.container = container;
}

CountryDetailView.prototype = {

  display: function (country) {
    var pTags = this.container.querySelectorAll('p');
    pTags[0].innerText = country.name;
    pTags[1].innerText = country.population;
    pTags[2].innerText = country.capital;
  }

}
