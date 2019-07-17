var position = {
  x:0,
  y:0,
  moveAmount:10,
  setInBounds:function() {
    if(this.x<0) this.x = 0;
    if(this.y<0) this.y = 0;
  },
  moveUp:function() {
    this.y = this.y - this.moveAmount;
    this.setInBounds();
  },
  moveDown:function() {
    this.y = this.y + this.moveAmount;
    this.setInBounds();
  },
  moveLeft:function() {
    this.x = this.x - this.moveAmount;
    this.setInBounds();
  },
  moveRight:function() {
    this.x = this.x + this.moveAmount;
    this.setInBounds();
  }
};

module.exports = position;
