const Hero = require('../hero.js');
const Food = require('../food.js');
const Task = require('../task.js');
const levels = require('../levels.js');
const assert = require('assert');

describe('Hero', function () {
  let hero;

  let burger;
  let pizza;
  let poisonedPizza;

  let task1;
  let task2;
  let task3;

  beforeEach(function () {
    hero = new Hero('Jarrod', 'pizza');

    burger = new Food('burger', 5);
    pizza = new Food('pizza', 10);
    poisonedPizza = new Food('pizza', 10);
    poisonedPizza.poison();

    task1 = new Task(levels.low, levels.low, 5);
    task2 = new Task(levels.medium, levels.medium, 10);
    task3 = new Task(levels.high, levels.high, 25);
  })

  it('should have a name', function () {
    assert.strictEqual(hero.name, 'Jarrod');
  });

  it('should have health', function () {
    assert.strictEqual(hero.health, 100);
  });

  it('should have a favourite food', function () {
    assert.strictEqual(hero.favouriteFood, 'pizza');
  });

  it('should be able to talk', function () {
    assert.strictEqual(hero.talk(), 'Hi! My name is Jarrod.');
  });

  describe('Eating', function () {
    it('should gain health when eating food', function () {
      hero.health = 80;
      hero.eat(burger);
      assert.strictEqual(hero.health, 85);
    });

    it('should gain extra health when eating favourite food', function () {
      hero.health = 80;
      hero.eat(pizza);
      assert.strictEqual(hero.health, 95);
    });

    it('should lose health when eating poisoned food', function () {
      hero.eat(poisonedPizza);
      assert.strictEqual(hero.health, 90);
    });

    it('should not be able to exceed 100 health', function () {
      hero.eat(pizza);
      assert.strictEqual(hero.health, 100);
    });
  });


  describe('Tasks', function () {
    it('should start with an empty collection of tasks', function () {
      assert.deepStrictEqual(hero.tasks, []);
    });

    it('should be able to add a task', function () {
      hero.addTask(task1);
      assert.deepStrictEqual(hero.tasks, [task1]);
    });

    it('should be able to remove a task', function () {
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      hero.removeTask(task2);
      assert.deepStrictEqual(hero.tasks, [task1, task3]);
    });

    it('should be able to sort tasks by difficulty', function () {
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      hero.sortTasks('difficulty');
      assert.deepStrictEqual(hero.tasks, [task3, task2, task1]);
    });

    it('should be able to sort tasks by urgency', function () {
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      hero.sortTasks('urgency');
      assert.deepStrictEqual(hero.tasks, [task3, task2, task1]);
    });

    it('should be able to sort tasks by reward', function () {
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      hero.sortTasks('reward');
      assert.deepStrictEqual(hero.tasks, [task3, task2, task1]);
    });

    it('should be able to get complete tasks', function () {
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      task1.toggleIsComplete();
      task3.toggleIsComplete();
      assert.deepStrictEqual(hero.getCompletedTasks(), [task1, task3]);
    });

    it('should be able to get complete tasks', function () {
      hero.addTask(task1);
      hero.addTask(task2);
      hero.addTask(task3);
      task2.toggleIsComplete();
      assert.deepStrictEqual(hero.getIncompleteTasks(), [task1, task3]);
    });
  });
});
