var lastCountry = {

  storageKey: "selectedCountry",

  save: function (country) {
    if (!country) return;
    localStorage.setItem(this.storageKey,JSON.stringify(country));
  },

  get: function () {
    var countryString = localStorage.getItem("selectedCountry");
    if (!countryString) return;
    return JSON.parse(countryString);
  }
  
}
