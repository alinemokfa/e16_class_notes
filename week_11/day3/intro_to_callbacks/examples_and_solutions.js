//A FUNCTION TAKING A FUNCTION AS AN ARGUMENT
setTimeout(function() {
  console.log("I waited for 1 second");
}, 1000);


//A FUNCTION RETURNING A FUNCTION
var add = function(firstNumber) {
  return function(secondNumber) {
    return firstNumber + secondNumber;
  };
};

var addFiveFunction = add(5);
console.log(addFiveFunction(3));


//CALLING A FUNCTION IN A FUNCTION
var logRed = function() {
  console.log("It's red!");
};

var logNotRed = function() {
  console.log("It's NOT red!");
};

var redChecker = function(colour, isRed, isNotRed) {
  if(colour === "red") {
    isRed();
  }
  else{
    isNotRed();
  }
};

redChecker("red", logRed, logNotRed);

//PASSING ARGUMENTS TO CALLBACKS

var logRed = function(message) {
  console.log(message);
};

var redChecker = function(message, colour, isRed, isNotRed) {
  if(colour === "red") {
    isRed(message);
  }
  else{
    isNotRed();
  }
};

redChecker("Print out this new message please!", "red", logRed, logNotRed);


//CALLBACK EXERCISES

//1. ////////////////////////////////////////////////////////
var callback = function(number) {
  console.log("My number is " + number);
};

var functionCaller = function(myCallback, arg) {
  return myCallback(arg);
};

functionCaller(callback, 5);

//2. //////////////////////////////////////////////////////

var getSomethingFromTheShop = function(budget, callback) {
  console.log("I have " + budget + " to go to the shop");
  var wanted = "Star Bar";
  var got = "Curly Wurly";

  callback(wanted, got);
};

getSomethingFromTheShop("£0.50", function(req, res) {
    console.log("I wanted a " + req + " but all I got was a " + res);
});

//3. ////////////////////////////////////////////////////////
var increment = function(n) {
  return n+1;
};

var square = function(n) {
  return n*n;
};

var doSomeMathsForMe = function(n, func) {
  return func(n);
};

console.log(doSomeMathsForMe(3, increment));
console.log(doSomeMathsForMe(10, square));


function getTweetsAsync(callback) {
  //Go and get the tweets
  
  setTimeout(function() {
    var tweets = "These are the tweets";
    callback(tweets);
  }, 1000);

}

var myTweets = null;
getTweetsAsync(function(tweets) {
  myTweets = tweets;
});

console.log(myTweets); //NULL!

