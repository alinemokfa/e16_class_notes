require('minitest/autorun')
require('minitest/rg')
require_relative('../motorbike.rb')

class TestMotorbike < Minitest::Test
  def setup
    @motorbike = Motorbike.new()
  end

  def test_motorbike_can_start_engine
    assert_equal("Vrrmmm (I'm a motorbike), HELL YEAH!", @motorbike.start_engine)
  end

  def test_motorbike_has_two_wheels
    assert_equal(2, @motorbike.number_of_wheels)
  end
end
