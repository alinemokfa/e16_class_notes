# Requests Homework

## Learning Objectives
- Practice making JavaScript requests and displaying the data in the page
- Practice traversing the data structure received from an API

## Tasks
- Make an XMLHttpRequest to get data on brewdog beers back from [this API: `https://api.punkapi.com/v2/beers`](https://api.punkapi.com/v2/beers)
- Display a list of the names of the beers
  - try to use small, reuseable functions, for example, one to handle looping through all the data, then using a separate function to create and render each item into the list.
- Add an `<img>` to each beer
  - there is an `"image_url"` key on the beer objects we get back from the API

## Extensions
- Add a list of ingredients for each beer
  - There are 3 different types of `"ingredients"` on the beer object we get back - `"malt"`, `"hops"`, and `"yeast"`. You can choose which to display, or if you're feeling ambitious, try to combine all three into one array and display them all.
- Refactor to only show details about one beer, and add a dropdown to select the beer to display

#### We have provided a skeleton start point.
