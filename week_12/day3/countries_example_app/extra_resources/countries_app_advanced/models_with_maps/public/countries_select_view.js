var CountrySelectView = function (selectElement) {
  this.selectElement = selectElement;
  this.onChange = undefined;
  this.countries = [];
  this.selectElement.addEventListener('change', function (e) {
      var target = e.target;
      var index = target.selectedIndex;
      var country = this.countries[target.selectedIndex];
      country.index = index;
      this.onChange(country);
  }.bind(this), false);
};

CountrySelectView.prototype = {
  populate:function (countries) {
    this.selectElement.innerHTML = "";
    this.countries = countries;
    var index = 0;
    
    this.countries.forEach(function (country) {
      console.log('addingcountry as', country);
      this.addOption(country, index);
      index++;
    }.bind(this));
  },

  addOption:function (country, index) {
    var option = document.createElement("option");
    option.value = index.toString();
    option.text = country.name;
    this.selectElement.appendChild(option);
  },

  setSelectedIndex:function (index) {
    console.log('setting index', index);
    this.selectElement.selectedIndex = index;
  }
};
