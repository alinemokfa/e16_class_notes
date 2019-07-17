var ChartData = function() {
  this.pie = [{
    name: "Type",
    data: [{   
      name: "Fire", 
      y: 45,
      color: "#ffac33"
    },
    {
      name: "Water",
      y: 25,
      sliced: true,
      color: "#73b7ff"
    },
    { 
      name: "Grass", 
      y: 2,
      color: "#00ba2f"

    },
    { 
      name: "Electric", 
      y: 28,
      color: "#ffee70"
    }]
  }],
  this.series = [{
    name: "Water Pokemon",
    color: "#73b7ff",
    data: [2, 7, 10, 12, 14, 17, 13, 14, 21, 19, 9, 5]
  },
  {
    name: "Fire Pokemon",
    color: "#ffac33",
    data: [4, 3, 5, 18, 11, 2, 18, 3, 18, 11, 3, 7]
  },
  {
    name: "Grass Pokemon",
    color: "#00ba2f",
    data: [1, 2, 1, 1, 1, 4, 3, 2, 1, 4, 3, 1]
  }],
  this.months = {
    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
  };
};
