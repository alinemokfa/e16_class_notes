const Task = function (difficulty, urgency, reward) {
  this.difficulty = difficulty;
  this.urgency = urgency;
  this.reward = reward;
  this.isComplete = false;
}

Task.prototype.toggleIsComplete = function () {
  this.isComplete = !this.isComplete;
}

module.exports = Task;
