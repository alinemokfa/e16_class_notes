var init = function(){
  var button = document.querySelector('button');
  button.addEventListener('click', handleButtonClick);

  var todosArray = JSON.parse(localStorage.getItem('todoList')) || [];
  populate(todosArray);
}

var populate = function(todos){
  todos.forEach(function(item){
    addItem(item);
  });
}

var addItem = function(item){
  var ul = document.querySelector('#todo-list');
  var newItem = document.createElement('li');
  newItem.innerText = item;
  ul.appendChild(newItem);
}

var handleButtonClick = function(){
  var input = document.querySelector('#new-item');
  addItem(input.value);
  save(input.value);
}

var save = function(newItem){
  var todosArray = JSON.parse(localStorage.getItem('todoList')) || [];
  todosArray.push(newItem);
  localStorage.setItem('todoList', JSON.stringify(todosArray));
}

window.onload = init;
