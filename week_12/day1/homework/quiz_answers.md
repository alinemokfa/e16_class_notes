# Quiz

1. What does DOM stand for?
Document Object Model

2. What is the name of the object we can use to get information about the browser enviroment?
window

3. What is the name of the object that we can use to get access to the DOM representation of the page?
document

4. Name 3 type of files we might see in the Network tab in Chrome devTools
css, js, html, images

5. What version of HTML is document.querySelector from?
5

6. Which event do we hook into when we want to know the DOM has loaded, window.onload or document.onload?
window.onload

7. We use window.createElement to make new DOM elements, true or false?
false (document.createElement)

8. List two ways to get all the elements with class 'cat'

document.querySelectorAll('.cat')
document.getElementsByClassName('cat')

9. List two ways to retrieve the element with id "goat"

document.querySelector('#goat')
document.getElementById('goat')

10. List two ways to get all the li elements
document.querySelectorAll('li')
document.getElementsByTagName('li')

11. List two ways to get the first li element
document.querySelector('li')
document.getElementsByTagName('li')[0]

12. How can we set the cats element to be hidden?
var element = document.getElementById('cat')
element.style.display = "none";
element.style.visibility = "hidden";
