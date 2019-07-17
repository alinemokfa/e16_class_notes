const PieChart = function() {
  const container = document.querySelector('#pie-chart');

  const options = {
    chart: {
      type: 'pie',
      renderTo: container
    },
    title: {
      text: 'Movie types i like'
    },
    series: [
      {
        name: 'Genre',
        data: [
          {
            name: 'SciFi',
            color: '#ff0000',
            y: 5
          },
          {
            name: 'Thriller',
            color: '#00ff00',
            y: 15
          },
          {
            name: 'Comedy',
            color: '#0000ff',
            y: 10,
            sliced: true
          }
        ]
      }
    ]
  }

  const chart = new Highcharts.Chart(options);
}
