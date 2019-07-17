var storage = {

  key: 'selectedCountry',

  save: function (country) {
    if (!country) return;
    var jsonString = JSON.stringify(country);
    localStorage.setItem(this.key, jsonString);
  },

  get: function () {
    var jsonString = localStorage.getItem(this.key);
    return JSON.parse(jsonString);
  }

};
