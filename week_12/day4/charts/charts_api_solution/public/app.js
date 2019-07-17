window.addEventListener('load', function() {
  var url = "https://restcountries.eu/rest/v1";
  var request = new XMLHttpRequest();
  request.open("GET", url);
  request.send();

  request.addEventListener('load', function() {
    loadCountryCharts(request.responseText);
  });

});

var loadCountryCharts = function(responseText) {
  var countries = JSON.parse(responseText);

  countryPopulationData = [];

  for(country of countries) {
    countryPopulationData.push({
      name: country.name,
      y: country.population
    });
  }

  var countryRegionData = {
    name: "Number of Countries",
    data: []
  };

  var countryRegionLabels = [];

  for(country of countries) {
    if(!countryRegionLabels.includes(country.region)) {
      countryRegionLabels.push(country.region);
    }
  }

  for(label of countryRegionLabels) {
    var num = 0;
    for(country of countries) {
      if(country.region == label) {
        num ++;
      }
    }
    countryRegionData.data.push(num);
  }

  new PieChart("Country Populations", countryPopulationData);
  new ColumnChart("Countries in Different Regions", countryRegionData, countryRegionLabels);
};
