var initialize = function(){
  var mapDiv = document.getElementById('main-map');
  var chicagoButton = document.querySelector('#chicago-button');
  var whereAmIButton = document.querySelector('#geo-button');

  var center = { lat: 40.712784, lng: -74.005941 };

  var mainMap = new MapWrapper(mapDiv, center, 10);
  // mainMap.addMarker(center);
  mainMap.addClickEvent();
  mainMap.addInfoWindow(center, "Start spreadin' the news, I'm leavin' today <br>I want to be a part of it <br> <b>New York, New York</b>");

  var goToChicago = function(){
    var chicago = { lat: 41.878114, lng: -87.629798 };
    mainMap.googleMap.setCenter(chicago);
    mainMap.addInfoWindow(chicago, "<h3>Chicago</h3>"); 
  }

  var findLocation = function(){
    mainMap.geoLocate();
  }

  chicagoButton.addEventListener('click', goToChicago);
  whereAmIButton.addEventListener('click', findLocation);
}

window.addEventListener('load', initialize);
