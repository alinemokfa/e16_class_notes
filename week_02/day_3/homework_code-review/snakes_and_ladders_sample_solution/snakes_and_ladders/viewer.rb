class Viewer

  def get_player_name(player_number)
    puts "Player #{player_number}: Enter name"
    return gets.chomp
  end

  def start(player_name)
    puts
    puts "#{player_name} roll!"
    gets.chomp
  end

  def show_update(entry)
    puts "#{entry.player.name} rolled #{entry.roll}"
    if(entry.modifier != 0)
      puts "#{entry.player.name} hit a #{entry.modifier_type}! Moves #{entry.modifier}"
    end
    puts "#{entry.player.name} is on tile #{entry.player.position}"
  end

  def end(winner_name)
    puts "Congratulations, #{winner_name} wins"
  end
end