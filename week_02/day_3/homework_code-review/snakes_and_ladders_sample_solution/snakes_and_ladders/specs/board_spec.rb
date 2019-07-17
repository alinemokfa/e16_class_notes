require 'minitest/autorun'
require 'minitest/rg'

require_relative '../board'

class TestBoard < Minitest::Test
  def setup
    positions = {
      2 => 4,
      7 => -7,
    }
    @board = Board.new(9, positions)
  end

  def test_board_should_have_9_tiles
    assert_equal(9, @board.number_of_tiles)
  end

  def test_position_2_is_a_ladder
    assert_equal(4, @board.modifier_at_position(2))
  end

  def test_position_7_is_a_snake
    assert_equal(-7, @board.modifier_at_position(7))
  end

  def test_win_tile
    assert_equal(8, @board.win_tile)
  end

end