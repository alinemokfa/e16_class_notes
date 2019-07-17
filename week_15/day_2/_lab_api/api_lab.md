# Lab

Practise what we've learned in the past few days by making a small React app. This could be similar to the countries app we made that has a dropdown menu which when selected displays some information about that option. You could also select from a list of api's below or be creative and make something of your choice. 

This will be a pairing exercise. Remember to take turns coding every so often. 

Also remember to have a container and component folder. Containers will handle data requests, state changes and callbacks. Components will handle visualation logic (and only have access to props). 

Sample APIs:

## Netflix Roulette API

http://netflixroulette.net/api/

e.g. Choose a director or actor and make a dropdown of their films, click to show details. 

Use a query string with the URL to get a specific data set, i.e.

http://netflixroulette.net/api/api.php?actor=Nicolas%20Cage

## Pokemon API

http://pokeapi.co/

E.g. make a dropdown of the original Pokemon which you can select to see their details. This API uses URLS to link to more information rather than having one huge JSON response, so you will need to do a second AJAX request when an option is selected.

To get more than 20 Pokemon returned at once you can add a limit, e.g. http://pokeapi.co/api/v2/pokemon/?limit=151

## Harry Potter API

http://hp-api.herokuapp.com/

E.g. List all of the characters and click to see more info. You could extend this by filtering by Hogwarts House.

## Football Data

http://api.football-data.org/documentation

E.g. make a drop down box of all of the teams playing in the Premier League, and when selected show a list of the players for that team with their position and shirt number - this will need a second AJAX request on click. OR Make an app to look at the different football league tables.

You need to sign up for a free API key (http://api.football-data.org/register) which should be emailed to you right away, and then include this in any requests to the API as follows:


```
var url = 'http://api.football-data.org/v1/soccerseasons';
var request = new XMLHttpRequest();
request.open("GET", url);
request.setRequestHeader("X-Auth-Token", "TOKEN GOES HERE");
request.onload = function () {
}
request.send(null);
    
```


 


