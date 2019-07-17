const Task = require('../task.js');
const levels = require('../levels.js');
const assert = require('assert');

describe('Task', function () {
  let task;

  beforeEach(function () {
    task = new Task(levels.medium, levels.low, 100);
  })

  it('should have a difficulty', function () {
    assert.strictEqual(task.difficulty, levels.medium);
  });

  it('should have an urgency', function () {
    assert.strictEqual(task.urgency, levels.low);
  });

  it('should have a reward', function () {
    assert.strictEqual(task.reward, 100);
  });

  it('should initially be incomplete', function () {
    assert.strictEqual(task.isComplete, false);
  });

  it('should be able to be marked as complete', function () {
    task.toggleIsComplete();
    assert.strictEqual(task.isComplete, true);
  });

  it('should be able to be marked as incomplete', function () {
    task.isComplete = true;
    task.toggleIsComplete();
    assert.strictEqual(task.isComplete, false);
  });
});
