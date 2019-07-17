require_relative("turn_log")

class Game
  attr_reader :current_player, :winner, :log

  def initialize(players, board)
    @players = players
    @board = board
    @current_player = players[0]
    @winner = nil
    @log = []
  end

  def number_of_players
    return @players.count
  end

  def update_current_player
    @current_player = @players.rotate![0]
  end

  def next_turn(spaces)
    return if(is_won?)
    modifier = move_player(spaces)
    update_log(spaces, modifier)
    update_current_player
  end

  def update_log(spaces, modifier)
    @log << TurnLog.new(player: @current_player, roll: spaces, modifier: modifier)
  end

  def move_player(spaces)
   valid_move = validate_movement(spaces)
   @current_player.move(valid_move)

   modifier = @board.modifier_at_position(@current_player.position)
   @current_player.move(modifier)

   return modifier
  end

  def validate_movement(spaces)
    distance_to_end = @board.win_tile - @current_player.position
    movement = spaces > distance_to_end ? distance_to_end : spaces
    return movement
  end

  def is_won?
    for player in @players
      @winner = player if player.position >= @board.win_tile
    end
    return !@winner.nil?
  end

end
