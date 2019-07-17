var app = function(){
  var url = 'https://restcountries.eu/rest/v2';
  var button = document.getElementById('fetch-btn');

  button.addEventListener('click', function(){
    console.log("fetching...");
    makeRequest(url, requestComplete);
  });
}

var makeRequest = function(url, callback){
  var request = new XMLHttpRequest();
  request.open("GET", url);
  request.addEventListener('load', callback);
  request.send();
}

var requestComplete = function(){
  if(this.status !== 200) return;
  var jsonString = this.responseText;
  var countries = JSON.parse(jsonString);
  populateList(countries);
}

var populateList = function(countries){
  var ul = document.getElementById('country-list');

  countries.forEach(function(country){
    var li = document.createElement('li');
    li.innerText = country.name;
    ul.appendChild(li);
  });

}

window.addEventListener('load', app);
