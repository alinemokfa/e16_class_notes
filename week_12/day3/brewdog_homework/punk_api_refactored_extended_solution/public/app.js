var app = function () {
  var url = 'https://api.punkapi.com/v2/beers';
  var request = new XMLHttpRequest();
  request.open('GET', url);

  request.addEventListener('load', function () {
    var beersData = JSON.parse(request.responseText);
    renderDropDown(beersData);
    // renderList(beersData);
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

// Drop-down select
var renderDropDown = function (beersData) {
  var dropDown = createDropDown(beersData);
  var mainDiv = document.getElementById('main');

  mainDiv.appendChild(dropDown);
}

var createDropDown = function (beers) {
  var select = document.createElement('select');

  var defaultOption = document.createElement('option');
  defaultOption.innerText = 'Select a beer';
  defaultOption.value = -1;
  defaultOption.disabled = true;
  defaultOption.selected = true;
  select.appendChild(defaultOption);

  beers.forEach(function (beerObject, index) {
    var optionTag = createOptionTag(beerObject.name, index);
    select.appendChild(optionTag);
  });
  select.addEventListener('change', function (event) {
    var selectedIndex = event.target.value;
    selectBeer(beers, selectedIndex);
  });
  return select;
}

var createOptionTag = function (text, index) {
  var option = document.createElement('option');
  option.innerText = text;
  option.value = index;
  return option;
}

var selectBeer = function (beers, selectedIndex) {
  var beerObject = beers[selectedIndex];
  var beerElement = createListItem(beerObject);
  renderSingleBeer(beerElement);
}

var renderSingleBeer = function (beerElement) {
  var mainDiv = document.getElementById('main');

  var existingBeerListItem = document.querySelector('li');
  if (existingBeerListItem !== null) {
    mainDiv.removeChild(existingBeerListItem);
  }

  mainDiv.appendChild(beerElement);
}

window.addEventListener('load', app);
