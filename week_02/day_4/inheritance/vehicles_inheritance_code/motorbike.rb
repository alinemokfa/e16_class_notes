require_relative('vehicle.rb')

class Motorbike < Vehicle

  def initialize
    super(2)
  end

  def start_engine
    return "Vrrmmm (I'm a motorbike), HELL YEAH!"
  end
  
end
