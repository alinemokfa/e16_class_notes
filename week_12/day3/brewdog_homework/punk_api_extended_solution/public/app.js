var app = function () {
  var url = 'https://api.punkapi.com/v2/beers';
  var request = new XMLHttpRequest();
  request.open('GET', url);

  request.addEventListener('load', function () {
    var beersData = JSON.parse(request.responseText);
    renderList(beersData);
  });

  request.send();
};

// List beers
var renderList = function (beersObjects) {
  var mainDiv = document.getElementById('main');
  var list = document.createElement('ul');

  beersObjects.forEach(function (beer) {
    var li = createListItem(beer);
    list.appendChild(li);
  });

  mainDiv.appendChild(list);
};

var createListItem = function (beerObject) {
  var li = document.createElement('li');
  li.innerText = beerObject.name;
  var img = createImage(beerObject);
  li.appendChild(img);
  var ingredientsList = createIngredientsList(beerObject);
  li.appendChild(ingredientsList);
  return li;
};

var createImage = function (beer) {
  var image = document.createElement('img');
  image.src = beer.image_url;
  image.alt = beer.name;
  return image;
};

// Ingredients list
var createIngredientsList = function (beerObject) {
  var list = document.createElement('ul');
  var ingredients = combineIngredients(beerObject);

  ingredients.forEach(function (ingredientString) {
    var listItem = document.createElement('li');
    listItem.innerText = ingredientString;
    list.appendChild(listItem);
  });
  return list;
};

var combineIngredients = function (beer) {
  var malts = beer.ingredients.malt;
  var hops = beer.ingredients.hops;
  var combinedIngredients = malts.concat(hops);

  var ingredientNameStrings = combinedIngredients.map(function (ingredient) {
    return ingredient.name;
  });

  ingredientNameStrings.push(beer.ingredients.yeast);

  var uniqueNames = removeDuplicates(ingredientNameStrings);
  return uniqueNames;
}

var removeDuplicates = function (ingredients) {
  var uniqueIngredients = ingredients.filter(function (ingredient, currentIndex) {
    var firstIndexOfIngredient = ingredients.indexOf(ingredient);

    // full with if statement
    var firstOccurence;
    if (firstIndexOfIngredient === currentIndex) {
      firstOccurence = true
    }
    else {
      firstOccurence = false
    }
    return firstOccurence;

    // shortcut - assign condition result directly
    var firstOccurence = (firstIndexOfIngredient === currentIndex);
    return firstOccurence;

    // extra shortcut - return condition result directly without assigning
    return firstIndexOfIngredient === currentIndex;
  });
  return uniqueIngredients;
}

window.addEventListener('load', app);
