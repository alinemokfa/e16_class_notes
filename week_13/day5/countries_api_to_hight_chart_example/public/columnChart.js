const ColumnChart = function(countryNames, populations) {

  const container = document.querySelector('#column-chart');

  const options = {
    chart: {
      type: 'column',
      renderTo: container
    },
    title: {
      text: 'Countries Population'
    },
    series: [
      {
        name: "Country Pop",
        data: populations
      }
    ],
    xAxis: {
      categories: countryNames
    }
  }

  const chart = new Highcharts.Chart(options);

}
