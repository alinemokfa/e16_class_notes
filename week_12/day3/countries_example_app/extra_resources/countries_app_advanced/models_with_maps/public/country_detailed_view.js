var CountryDetailView = function (element) {
  this.element = element;
};

CountryDetailView.prototype = {
  display: function (country) {
    this.country = country;
    console.log("element", this.element);
    var tags = this.element.querySelectorAll('p');
    tags[0].innerText = country.name;
    tags[1].innerText = country.population;
    tags[2].innerText = country.capital;
    this.addMap(country);
  },

  addMap: function (country) {
    var latlng = {lat: country.latlng[0], lng: country.latlng[1]};
    var map = new google.maps.Map(document.getElementById('map'), {
      center: latlng,
      zoom: 5
    });

    var addMarker = function () {
      var marker = new google.maps.Marker({
        position: latlng,
        map: map,
      });

      var addInfoWindow = function () {
        marker.addListener('click', function () {
          var infowindow = new google.maps.InfoWindow({
            content: "<h4>"+ country.name +"</h4> <p>" + country.subregion + "</p>"
          });
          infowindow.open(map, marker);
        });
      }
      addInfoWindow();
    }
    addMarker();
  }
}
