require 'minitest/autorun'
require 'minitest/rg'
require_relative '../game'
require_relative '../player'
require_relative '../board'

class TestGamePlay < Minitest::Test

  def setup
    positions = {
     2 => 4,
     7 => -7,
   }

   board = Board.new(9, positions)

   @player1 = Player.new("Val")
   @player2 = Player.new("Rick")

   players = [@player1, @player2]

   @game = Game.new(players, board)

  end

  def test_simple_win

    @game.next_turn(6)
    assert_equal(6,@player1.position)

    @game.next_turn(1)
    assert_equal(1,@player2.position)

    @game.next_turn(2)
    assert_equal(8,@player1.position)
    
    assert_equal(true, @game.is_won?)
    assert_equal(@player1, @game.winner)

  end

  def test_game_snake_win

    @game.next_turn(6)
    assert_equal(6,@player1.position)

    @game.next_turn(6)
    assert_equal(6,@player2.position)

    @game.next_turn(1)
    assert_equal(0,@player1.position)

    @game.next_turn(2)
    assert_equal(8,@player2.position)

    assert_equal(true, @game.is_won?)
    assert_equal(@player2, @game.winner)

  end

  def test_game_ladder_win

    @game.next_turn(2)
    assert_equal(6,@player1.position)

    @game.next_turn(1)
    assert_equal(1,@player2.position)

    @game.next_turn(2)
    assert_equal(8,@player1.position)

    assert_equal(true, @game.is_won?)
    assert_equal(@player1, @game.winner)

  end

end
