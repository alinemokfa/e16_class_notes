require_relative('vehicle.rb')

class Car < Vehicle
  attr_reader :model

  def initialize(model)
    super(4)
    @model = model
  end
  
end
