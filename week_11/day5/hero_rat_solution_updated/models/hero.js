const Hero = function (name, favouriteFood) {
  this.name = name;
  this.favouriteFood = favouriteFood;
  this.health = 100;
  this.tasks = [];
}

Hero.prototype.talk = function () {
  return `Hi! My name is ${ this.name }.`;
}

Hero.prototype.addTask = function (task) {
  this.tasks.push(task);
}

Hero.prototype.removeTask = function (task) {
  const indexToRemove = this.tasks.indexOf(task);
  this.tasks.splice(indexToRemove, 1);
};

Hero.prototype.sortTasks = function (propertyToSortBy) {
  this.tasks.sort(function (prevTask, nextTask) {
    return nextTask[propertyToSortBy] - prevTask[propertyToSortBy];
  });
}

Hero.prototype.getCompletedTasks = function () {
  return this.tasks.filter(function (task) {
    return task.isComplete;
  });
};

Hero.prototype.getIncompleteTasks = function () {
  return this.tasks.filter(function (task) {
    return !task.isComplete;
  });
};

Hero.prototype.eat = function (food) {
  if (!food.isPoisoned) {
    const replenishmentMultiplier = food.name === this.favouriteFood ? 1.5 : 1;
    this.health += (food.replenishmentValue * replenishmentMultiplier);
  }
  else {
    this.health -= food.replenishmentValue;
  }

  if (this.health > 100) {
    this.health = 100;
  }
}

module.exports = Hero;
