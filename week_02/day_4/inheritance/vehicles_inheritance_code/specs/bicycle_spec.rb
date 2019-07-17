require('minitest/autorun')
require('minitest/rg')
require_relative('../bicycle.rb')

class TestBicycle < Minitest::Test
  def setup
    @bike = Bicycle.new()
  end

  def test_bicycle_has_two_wheels
    assert_equal(2, @bike.number_of_wheels)
  end
end
