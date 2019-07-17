require('minitest/autorun')
require('minitest/rg')
require_relative('../bear.rb')
require_relative('../river.rb')
require_relative('../fish.rb')

class TestBear < MiniTest::Test

  def setup()
    @bear = Bear.new('Yogi')

    fish_1 = Fish.new('Tuna Turner')
    fish_2 = Fish.new('Margaret')
    fish = [fish_1, fish_2]
    @river = River.new('Forth', fish)
  end

  def test_bear_has_name
    assert_equal('Yogi', @bear.name())
  end

  def test_bear_stomach_starts_empty()
    assert_equal(0, @bear.stomach.count())
  end

  def test_bear_can_take_fish_from_river()
    @bear.take_fish(@river)
    assert_equal(1, @bear.stomach.count())
  end

end
