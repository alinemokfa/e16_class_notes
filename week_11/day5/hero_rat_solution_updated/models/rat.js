const Rat = function () {

}

Rat.prototype.poison = function (food) {
  food.poison();
};

module.exports = Rat;
