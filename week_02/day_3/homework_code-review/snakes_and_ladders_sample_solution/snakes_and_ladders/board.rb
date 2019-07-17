class Board
  def initialize(size, positions)
    @state = Array.new(size,0)
    set_up_positions(positions)
  end

  def set_up_positions(positions)
    for key in positions.keys
      @state[key] = positions[key]
    end
  end

  def modifier_at_position(position)
    return @state[position]
  end

  def number_of_tiles
    return @state.length
  end

  def win_tile
    @state.size - 1
  end

end