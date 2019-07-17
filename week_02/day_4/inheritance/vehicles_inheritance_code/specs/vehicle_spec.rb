require('minitest/autorun')
require('minitest/rg')
require_relative('../vehicle.rb')

class TestVehicle < Minitest::Test
  def setup
    @vehicle = Vehicle.new(4)
  end

  def test_vehicle_has_number_of_wheels
    assert_equal(4, @vehicle.number_of_wheels)
  end

  def test_vehicle_can_start_engine
    assert_equal("Vrrmmm", @vehicle.start_engine)
  end
end
