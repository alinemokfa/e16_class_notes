require('minitest/autorun')
require('minitest/rg')
require_relative('../fish.rb')

class TestFish < MiniTest::Test
  def setup
    @fish = Fish.new('Tuna Turner')
  end

  def test_fish_has_name
    assert_equal('Tuna Turner', @fish.name())
  end
end
