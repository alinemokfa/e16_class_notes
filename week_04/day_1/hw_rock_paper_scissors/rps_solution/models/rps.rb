class RPSGame

  def self.check_win(hand1, hand2)
    hand1 = hand1.downcase
    hand2 = hand2.downcase

    if hand1 == hand2
      return "Draw!"
    end

    if hand1 == "rock" && hand2 == "scissors"
      return "Rock wins!"
    elsif hand1 == "rock" && hand2 == "paper"
      return "Paper wins!"
    elsif hand1 == "paper" && hand2 == "scissors"
      return "Scissors wins!"
    elsif hand1 == "paper" && hand2 == "rock"
      return "Paper wins!"
    elsif hand1 == "scissors" && hand2 == "paper"
      return "Scissors wins!"
    elsif hand1 == "scissors" && hand2 == "rock"
      return "Rock wins!"
    end

    return "oops, looks like you didn't enter valid inputs!"
  end

end