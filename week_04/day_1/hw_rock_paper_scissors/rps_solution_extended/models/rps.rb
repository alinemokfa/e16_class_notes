class RPSGame

  def self.check_win(player1, player2)
    hand1 = player1[:hand].downcase
    hand2 = player2[:hand].downcase

    winner = nil

    if (hand1 == "rock" && hand2 == "scissors") || 
       (hand1 == "paper" && hand2 == "rock") || 
       (hand1 == "scissors" && hand2 == "paper")
      winner = player1
    elsif (hand1 == "rock" && hand2 == "paper") ||
       (hand1 == "paper" && hand2 == "scissors") || 
       (hand1 == "scissors" && hand2 == "rock")
      winner = player2
    end

    if winner != nil
      return "Player #{winner[:player_no]} won by playing #{winner[:hand]}!"
    elsif hand1 == hand2
      return "It was a draw."
    else
      return "oops, looks like you didn't enter valid inputs!"
    end

  end


end