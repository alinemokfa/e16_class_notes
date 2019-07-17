class Bear

  attr_reader(:name, :stomach)

  def initialize(name)
    @name = name
    @stomach = []
  end

  def take_fish(river)
    fish = river.give_fish()
    @stomach.push(fish)
  end

end
