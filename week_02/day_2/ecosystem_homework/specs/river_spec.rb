require('minitest/autorun')
require('minitest/rg')
require_relative('../river.rb')
require_relative('../fish.rb')

class TestRiver < MiniTest::Test
  def setup
    fish_1 = Fish.new('Tuna Turner')
    @fish_2 = Fish.new('Margaret')
    fish = [fish_1, @fish_2]
    @river = River.new('Forth', fish)
  end

  def test_river_has_name()
    assert_equal('Forth', @river.name())
  end

  def test_river_has_fish()
    assert_equal(2, @river.fish.count())
  end

  def test_river_can_give_fish()
    result = @river.give_fish()
    assert_equal(@fish_2, result)
    assert_equal(1, @river.fish.count())
  end
end
