window.addEventListener('load', function () {
  var url = 'https://restcountries.eu/rest/v2';

  makeRequest(url, function () {
    if (this.status !== 200) return;
    var jsonString = this.responseText;
    var countries = JSON.parse(jsonString);
    render(countries);
  });
});

var makeRequest = function (url, callback) {
  var request = new XMLHttpRequest();
  request.open('GET', url);
  request.addEventListener('load', callback);
  request.send();
}

var render = function (countries) {
  var storedCountry = localStorage.getItem('selectedCountry');
  var countryToDisplay = null;

  if (storedCountry) {
    countryToDisplay = JSON.parse(storedCountry);
    var select = document.querySelector('#countries');
    select.selectedIndex = countryToDisplay.index;
  }
  else {
    countryToDisplay = countries[0];
  }

  populateSelect(countries);
  updateInfo(countryToDisplay);
}

var populateSelect = function (countries) {
  var select = document.querySelector('#countries');
    
  countries.forEach(function (item, index) {
    item.index = index;
    var option = document.createElement('option');
    option.value = index;
    option.text = item.name;
    select.appendChild(option);
  });

  select.addEventListener('change', function (event) {
    var index = this.value;
    var country = countries[index];
    
    updateInfo(country);

    var jsonString = JSON.stringify(country);
    localStorage.setItem('selectedCountry', jsonString);
  });
}

var updateInfo = function (country) {
  var pTags = document.querySelectorAll('#info p');
  pTags[0].innerText = country.name;
  pTags[1].innerText = country.population;
  pTags[2].innerText = country.capital;
}
