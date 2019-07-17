window.addEventListener('load', function () {
  // Setup country list model
  var countryList = new CountryList('https://restcountries.eu/rest/v1');
  countryList.getData();

  // Setup views
  var select = document.querySelector('#countries');
  var countrySelectView = new CountrySelectView(select, countryList);

  var info = document.querySelector('#info');
  var countryDetailView = new CountryDetailView(info);

  // Link change on select to update detail view
  countrySelectView.onChange = function (country) {
    storage.save(country);
    countryDetailView.display(country);
  }
});
