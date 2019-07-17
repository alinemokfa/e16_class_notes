var init = function () {
  var select = document.querySelector('select');
  select.addEventListener('change', handleSelectChange);

  var button = document.querySelector('button');
  button.addEventListener('click', handleButtonClick); 
}

var populate = function (ul, state) {
  ul.innerHTML = "";

  state.forEach(function (item) {
    addItem(ul, item);
  });
}

var addItem = function (ul, item) {
  var newItem = document.createElement('li');
  newItem.innerText = item;
  ul.appendChild(newItem);
}

var handleButtonClick = function () {
  var input = document.querySelector('#new-item');
  var ul = document.querySelector('#todo-list');
  addItem(ul, input.value);

  var select = document.querySelector('select');
  var selectedList = select.value;

  save(selectedList, input.value);
  input.value = '';
}

var save = function (selectedList, newItem) {
  var state = JSON.parse(localStorage.getItem('todoList')) || {};

  if (!state[selectedList]) state[selectedList] = [];
  state[selectedList].push(newItem);
  
  localStorage.setItem('todoList', JSON.stringify(state));
}

handleSelectChange = function () {
  var state = JSON.parse(localStorage.getItem('todoList')) || {};
  
  var selectedListName = this.value;
  var selectedList = state[selectedListName] || [];

  var ul = document.querySelector('#todo-list');
  populate(ul, selectedList);
}

window.addEventListener('load', init);
