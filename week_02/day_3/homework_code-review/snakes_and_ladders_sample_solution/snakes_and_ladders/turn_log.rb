class TurnLog

  attr_reader :player, :roll, :modifier

  def initialize(params)
    @player = params[:player]
    @roll = params[:roll]
    @modifier = params[:modifier]
  end

  def modifier_type
    result = :space

    result = :ladder if @modifier > 0
    result = :snake if @modifier < 0
      
    return result
  end
end