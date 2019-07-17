document.addEventListener('DOMContentLoaded', function() {
  const pieChart = new PieChart();

  const request = new XMLHttpRequest();
  request.open("GET", "https://restcountries.eu/rest/v1");
  request.addEventListener('load', function() {
    if(this.status !== 200) {
      return;
    }

    const allCountries = JSON.parse(this.responseText);
    loadCountriesChart(allCountries);
  });
  request.send();
  // const columnChart = new ColumnChart();
});

const loadCountriesChart = function(allCountries) {
  const populations = [];
  const countryNames = [];

  allCountries.forEach(function(country) {
      countryNames.push(country.name);
      populations.push(country.population);
  });

  const columnChart = new ColumnChart(countryNames, populations);
}
