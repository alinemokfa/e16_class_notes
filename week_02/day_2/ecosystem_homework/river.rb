class River

  attr_reader(:name, :fish)

  def initialize(name, fish)
    @name = name
    @fish = fish
  end

  def give_fish()
    fish = @fish.pop()
    return fish
  end

end
